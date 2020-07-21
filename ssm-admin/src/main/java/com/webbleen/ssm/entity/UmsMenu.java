package com.webbleen.ssm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: ums_menu
 */
@Data
public class UmsMenu implements Serializable {
    /**
     * Column:    id
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  false
     * AutoIncrement:  true
     */
    private Long id;

    /**
     * 父级ID
     *
     * Column:    parent_id
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Long parentId;

    /**
     * 创建时间
     *
     * Column:    create_time
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 菜单名称
     *
     * Column:    title
     * Length:    100
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String title;

    /**
     * 菜单级数
     *
     * Column:    level
     * Length:    10
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Integer level;

    /**
     * 菜单排序
     *
     * Column:    sort
     * Length:    10
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Integer sort;

    /**
     * 前端名称
     *
     * Column:    name
     * Length:    100
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String name;

    /**
     * 前端图标
     *
     * Column:    icon
     * Length:    200
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String icon;

    /**
     * 前端隐藏
     *
     * Column:    hidden
     * Length:    10
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Integer hidden;

    private static final long serialVersionUID = 1L;
}