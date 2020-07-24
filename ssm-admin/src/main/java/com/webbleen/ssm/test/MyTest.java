package com.webbleen.ssm.test;

import com.webbleen.ssm.shiro.AdminRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-shiro.xml");

        context.start();

        DefaultWebSecurityManager securityManager = context.getBean("securityManager", DefaultWebSecurityManager.class);
        System.out.println(securityManager);
        LifecycleBeanPostProcessor lifecycleBeanPostProcessor = context.getBean("lifecycleBeanPostProcessor", LifecycleBeanPostProcessor.class);
        System.out.println("lifecycleBeanPostProcessor = " + lifecycleBeanPostProcessor);
        AdminRealm shiroRealm = context.getBean("shiroRealm", AdminRealm.class);
        System.out.println("shiroRealm = " + shiroRealm);
        ShiroFilterFactoryBean shiroFilter = context.getBean("shiroFilter", ShiroFilterFactoryBean.class);
        System.out.println("shiroFilter = " + shiroFilter);
    }


}