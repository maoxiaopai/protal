package com.richfit.iip.protal.config.shiro;

import com.richfit.iip.protal.entity.Permission;
import com.richfit.iip.protal.entity.User;
import com.richfit.iip.protal.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wusq
 * @date: 2018/12/8
 */
public class MyRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("授权");
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = null;
        try {
            authorizationInfo = new SimpleAuthorizationInfo();
//            User user = userService.findUserByUsername(username);
//            authorizationInfo.addRole(user.getRole().getCode());
            authorizationInfo.addRole("code");
//            List<Permission> list = user.getRole().getPermissionList();

            List<Permission> list = new ArrayList<>();
            Permission p1 = new Permission();
            p1.setPermission("per");
            list.add(p1);
            for(Permission p:list){
//                authorizationInfo.addStringPermission(p.getCode());
                authorizationInfo.addStringPermission(p.getPermission());
            }
        } catch (Exception e) {
            log.error("授权错误{}", e.getMessage());
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        log.info("登录认证");

        String username = (String) token.getPrincipal();
        User user = userService.findUserByUsername(username);
        if(user == null) {
            throw new UnknownAccountException(); // 没找到帐号
        }

        /*if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );

        return authenticationInfo;
    }

}
