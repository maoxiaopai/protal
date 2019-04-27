package com.richfit.iip.protal.fore.controller;


import com.richfit.iip.protal.entity.User;
import com.richfit.iip.protal.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "通过名字查找用户")
    @RequestMapping("/findUserByUsername")
    @ResponseBody
    public User findUserByUsername(String username) {
        LOGGER.info("username = {}", username);
        User user = userService.findUserByUsername(username);
        return user;
    }

    @ApiOperation(value = "列表查找")
    @GetMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    public Object userList(int pageNum, int pageSize, Model model) {
        LOGGER.info("pageNum = {}, pageSize = {}", pageNum, pageSize);
        List<User> lists = userService.list();

        return lists;
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    public String userAdd(){
        return "user/userAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    public String userDel(){
        return "user/userDel";
    }
}

