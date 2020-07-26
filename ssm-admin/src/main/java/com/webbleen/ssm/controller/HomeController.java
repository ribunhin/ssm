package com.webbleen.ssm.controller;

import com.webbleen.ssm.shiro.AdminProfile;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final static Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home(Model model) {
        return "index";
    }
    /**
     * 加载登录页
     * @return
     */
    @GetMapping("login")
    public String loginPage () {
        AdminProfile profile = (AdminProfile) SecurityUtils.getSubject().getPrincipal();
        if (profile == null) {
            return "login";
        }
        return "redirect:/admin";
    }

    /**
     * 登录表单提交后，shiro处理认证，如果成功，则返回指定url，如果认证失败则由本方法处理
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password, RedirectAttributes attributes) {
        attributes.addFlashAttribute("username", username);
        attributes.addFlashAttribute("password", "");
        attributes.addFlashAttribute("message", "用户名或密码错误");
        return "redirect:/login";
    }
}
