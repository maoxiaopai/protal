package com.richfit.iip.protal.dao;

import com.richfit.iip.protal.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User findUserByUsername(@Param("username") String username);

}
