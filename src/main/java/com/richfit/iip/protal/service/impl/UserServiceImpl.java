package com.richfit.iip.protal.service.impl;

import com.richfit.iip.protal.entity.User;
import com.richfit.iip.protal.dao.UserMapper;
import com.richfit.iip.protal.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findUserByUsername(String username) {
        return this.getBaseMapper().findUserByUsername(username);
    }
}
