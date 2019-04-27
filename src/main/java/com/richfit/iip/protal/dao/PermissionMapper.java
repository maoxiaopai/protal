package com.richfit.iip.protal.dao;

import com.richfit.iip.protal.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据角色id查找权限
     * @param roleId
     * @return
     */
    List<Permission> findPermissionByRoleId(@Param("roleId") long roleId);

}
