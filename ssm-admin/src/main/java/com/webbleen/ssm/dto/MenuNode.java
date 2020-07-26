package com.webbleen.ssm.dto;

import com.webbleen.ssm.entity.UmsMenu;
import lombok.Data;

import java.util.List;

/**
 * 后台菜单节点
 */
@Data
public class MenuNode extends UmsMenu {
    private List<MenuNode> children;
}
