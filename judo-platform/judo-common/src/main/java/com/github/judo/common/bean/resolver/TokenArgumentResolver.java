package com.github.judo.common.bean.resolver;

import com.alibaba.fastjson.JSON;
import com.github.judo.common.constant.SecurityConstants;
import com.github.judo.common.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: Token转化UserVo
 * @Version: 1.0
 */
@Slf4j
@Component
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 1. 入参筛选
     *
     * @param methodParameter 参数集合
     * @return 格式化后的参数
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //return methodParameter.getParameterType().equals(UserVO.class) && methodParameter.hasParameterAnnotation(LoginUser.class);
        return methodParameter.getParameterType().equals(UserVO.class);
    }

    /**
     * @param methodParameter       入参集合
     * @param modelAndViewContainer model 和 view
     * @param nativeWebRequest      web相关
     * @param webDataBinderFactory  入参解析
     * @return 包装对象
     * @throws Exception exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        return JSON.parseObject(request.getHeader(SecurityConstants.USER_INFO), UserVO.class);
        /*HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String username = request.getHeader(SecurityConstants.USER_HEADER);
        String roles = request.getHeader(SecurityConstants.ROLE_HEADER);
        if (StrUtil.isBlank(username) || StrUtil.isBlank(roles)) {
            log.warn("resolveArgument error username or role is empty");
            return null;
        } else {
            log.info("resolveArgument username :{} roles:{}", username, roles);
        }
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        List<SysRole> sysRoleList = new ArrayList<>();
        Arrays.stream(roles.split(",")).forEach(role -> {
            SysRole sysRole = new SysRole();
            sysRole.setRoleCode(role);
            sysRoleList.add(sysRole);
        });
        userVO.setRoleList(sysRoleList);
        return userVO;*/
    }
}
