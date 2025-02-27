package com.github.judo.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: spring boot 的异常对象
 * @Version: 1.0
 */
@Data
public class ErrorPojo implements Serializable {
    @JSONField(name = "timestamp")
    private long timestamp;
    @JSONField(name = "status")
    private int status;
    @JSONField(name = "error")
    private String error;
    @JSONField(name = "exception")
    private String exception;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "path")
    private String path;
}
