package com.github.judo.admin.controller;

import com.github.judo.admin.service.SysUserService;
import com.github.judo.common.constant.SecurityConstants;
import com.github.judo.common.util.Assert;
import com.github.judo.common.util.R;
import com.google.code.kaptcha.Producer;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 验证码提供
 * @Version: 1.0
 */
@Controller
public class ValidateCodeController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService userService;

    /**
     * 创建验证码
     *
     * @param request request
     * @throws Exception
     */
    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{randomStr}")
    public void createCode(@PathVariable String randomStr, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Assert.isBlank(randomStr, "机器码不能为空");
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        userService.saveImageCode(randomStr, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 发送手机验证码
     * 后期要加接口限制
     *
     * @param mobile 手机号
     * @return R
     */
    @ResponseBody
    @GetMapping(SecurityConstants.MOBILE_VALIDATE_CODE_URL_PREFIX + "/{mobile}")
    public R<Boolean> createCode(@PathVariable String mobile) {
        Assert.isBlank(mobile, "手机号不能为空");
        return userService.sendSmsCode(mobile);
    }

    /**
     * 发送注册手机验证码
     * 后期要加接口限制
     *
     * @param mobile 手机号
     * @return R
     */
    @ResponseBody
    @GetMapping(SecurityConstants.REGISTER_VALIDATE_CODE_URL_PREFIX + "/{mobile}")
    public R<Boolean> registerCode(@PathVariable String mobile) {
        Assert.isBlank(mobile, "手机号不能为空");
        return userService.sendRegisterCode(mobile);
    }
}

