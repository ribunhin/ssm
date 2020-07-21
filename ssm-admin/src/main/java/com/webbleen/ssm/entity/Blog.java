package com.webbleen.ssm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Blog implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Boolean appreciation;

    /**
     * 
     */
    private Boolean commentable;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private String firstPicture;

    /**
     * 
     */
    private String flag;

    /**
     * 
     */
    private Boolean published;

    /**
     * 
     */
    private Boolean recommend;

    /**
     * 
     */
    private Boolean shareStatement;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer views;

    /**
     * 
     */
    private Long typeId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String content;

    private static final long serialVersionUID = 1L;
}