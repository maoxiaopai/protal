package com.richfit.iip.protal.service;

import com.richfit.iip.protal.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
public interface UserService extends IService<User> {

    User findUserByUsername(String username);

}
