package com.github.judo.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.judo.admin.model.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 用户角色表 Mapper 接口
 * @Version: 1.0
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    Boolean deleteByUserId(@Param("userId") Integer userId);
}
