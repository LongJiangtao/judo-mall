package com.github.judo.mc.handler;

import com.github.judo.common.util.template.MobileMsgTemplate;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 抽象hander
 * @Version: 1.0
 */
public abstract class AbstractMessageHandler implements SmsMessageHandler {

    /**
     * 执行入口
     *
     * @param mobileMsgTemplate 信息
     */
    @Override
    public void execute(MobileMsgTemplate mobileMsgTemplate) {
        check(mobileMsgTemplate);
        if (!process(mobileMsgTemplate)) {
            fail(mobileMsgTemplate);
        }
    }

    /**
     * 数据校验
     *
     * @param mobileMsgTemplate 信息
     */
    @Override
    public abstract void check(MobileMsgTemplate mobileMsgTemplate);

    /**
     * 业务处理
     *
     * @param mobileMsgTemplate 信息
     * @return boolean
     */
    @Override
    public abstract boolean process(MobileMsgTemplate mobileMsgTemplate);

    /**
     * 失败处理
     *
     * @param mobileMsgTemplate 信息
     */
    @Override
    public abstract void fail(MobileMsgTemplate mobileMsgTemplate);
}
