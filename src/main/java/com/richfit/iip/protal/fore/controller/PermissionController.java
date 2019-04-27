package com.richfit.iip.protal.fore.controller;


import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author LiuZhenhua
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @ApiOperation("查询资源")
    @GetMapping("/get")
    @RequiresPermissions("permission:retrieve")
    public String get(){
        return "有permission:retrieve这个权限的用户才能访问，不然访问不了";
    }

}

