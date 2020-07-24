package com.webbleen.ssm.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.webbleen.ssm.entity.UmsAdmin;
import com.webbleen.ssm.service.AdminService;
import com.webbleen.ssm.utils.CipherUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 提供认证和授权数据
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    private final static Logger LOG = LoggerFactory.getLogger(AdminRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户信息，如果认证时设置的是自定义用户对象，则此处也是自定义对象
        AdminProfile profile = (AdminProfile)principals.getPrimaryPrincipal();
        LOG.info("doGetAuthorizationInfo - " + profile.getUsername());
        // 构造授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 管理员具有三个权限
        if ("admin".equals(profile.getUsername())) {
            info.addRole("admin");
            info.addStringPermission("user:view");
            info.addStringPermission("role:view");
            info.addStringPermission("menu:view");
            return info;
        }
        // 其他用户具有一个权限
        info.addRole("guest");
        info.addStringPermission("user:view");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        String password = new String(token.getPassword());

        UmsAdmin umsAdmin = adminService.findByUsername(username);
        if (umsAdmin == null) {
            throw new UnknownAccountException();
        }

        if (!CipherUtils.validatePassword(umsAdmin.getPassword(), password)) {
            throw new IncorrectCredentialsException();
        }
        // 构造认证信息，第一个参数为放在session中的对象
        AdminProfile profile = new AdminProfile();
        BeanUtil.copyProperties(umsAdmin, profile);
        return new SimpleAuthenticationInfo(profile, password, getName());
    }
}
