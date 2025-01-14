package com.github.judo.auth.config;

import lombok.Data;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: social 登录基础配置
 * @Version: 1.0
 */
@Data
public class SocialPropertiesConfig {
    /**
     * 提供商
     */
    private String providerId;
    /**
     * 应用ID
     */
    private String clientId;
    /**
     * 应用密钥
     */
    private String clientSecret;
}
