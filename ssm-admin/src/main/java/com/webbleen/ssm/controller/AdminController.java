package com.webbleen.ssm.controller;

import com.webbleen.ssm.service.AdminService;
import com.webbleen.ssm.shiro.AdminProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final static Logger LOG = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    private AdminService adminService;

    /**
     * 采用user过滤器
     * @return
     */
    @GetMapping
    public String index () {
        return "admin/index";
    }

    @GetMapping("main")
    public String main() {
        // 获取shiro中的用户信息，类似于之前从session中获取用户信息
        AdminProfile profile = (AdminProfile) SecurityUtils.getSubject().getPrincipal();
        LOG.info("当前用户：" + profile.getUsername());
        // 权限验证
        LOG.info("是否admin角色：" + SecurityUtils.getSubject().hasRole("admin"));
        LOG.info("是否具有menu:view权限：" + SecurityUtils.getSubject().isPermitted("menu:view"));

        return "admin/main";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", adminService.findAll());
        return "admin/users";
    }


    /**
     * 采用注解方式验证权限
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/msg")
    @ResponseBody
    public String getMsg () {
        return "true";
    }

}
