package com.richfit.iip.protal.dao;

import com.richfit.iip.protal.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    List<Role> findRoleByUsername(@Param("username") String username);

}
