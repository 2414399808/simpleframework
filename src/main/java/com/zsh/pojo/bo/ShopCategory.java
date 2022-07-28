package com.zsh.pojo.bo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_shop_category
 */
@Data
public class ShopCategory implements Serializable {
    /**
     * 店铺类别id
     */
    private Integer shopCategoryId;

    /**
     * 店铺类别名称
     */
    private String shopCategoryName;

    /**
     * 店铺类别描述
     */
    private String shopCategoryDesc;

    /**
     * 店铺类别图片地址
     */
    private String shopCategoryImg;

    /**
     * 创建时间
     */
    private Integer priority;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最近一次修改时间
     */
    private Date lastEditTime;

    /**
     * 店铺类别的父类别
     */
    private Integer parentId;

    private static final long serialVersionUID = 1L;


}