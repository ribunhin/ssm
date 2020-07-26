package com.webbleen.ssm.controller;

import com.webbleen.ssm.dto.MenuNode;
import com.webbleen.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("treeList")
    @ResponseBody
    public List<MenuNode> treeList() {
        return menuService.treeList();
    }
}
