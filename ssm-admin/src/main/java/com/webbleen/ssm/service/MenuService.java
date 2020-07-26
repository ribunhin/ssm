package com.webbleen.ssm.service;

import com.webbleen.ssm.dto.MenuNode;
import com.webbleen.ssm.entity.UmsMenu;

import java.util.List;

public interface MenuService {

    /**
     * 创建后台菜单
     * @param umsMenu
     * @return
     */
    int create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     * @param id
     * @param umsMenu
     * @return
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * 根据id获取菜单详情
     * @param id
     * @return
     */
    UmsMenu get(Long id);

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     * @return
     */
    List<MenuNode> treeList();

    /**
     *
     * @param id
     * @param hidden
     * @return
     */
    int updateHidden(Long id, Integer hidden);
}
