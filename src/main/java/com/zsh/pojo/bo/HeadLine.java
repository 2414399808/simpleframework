package com.zsh.pojo.bo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_head_line
 */
@Data
public class HeadLine implements Serializable {
    /**
     * 头条id
     */
    private Integer lineId;

    /**
     * 头条名称
     */
    private String lineName;

    /**
     * 头条连接
     */
    private String lineLink;

    /**
     * 头条图片地址
     */
    private String lineImg;

    /**
     * 展示的优先级
     */
    private Integer priority;

    /**
     * 可用状态
     */
    private Integer enableStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最近修改时间
     */
    private Date lastEditTime;

    private static final long serialVersionUID = 1L;


}