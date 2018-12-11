package com.github.judo.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.judo.admin.mapper.SysOauthClientDetailsMapper;
import com.github.judo.admin.model.entity.SysOauthClientDetails;
import com.github.judo.admin.service.SysOauthClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 服务实现类
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails> implements SysOauthClientDetailsService {

}
