package com.example.poetry.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Gushi)实体类
 *
 * @author fauchard
 * @since 2023-01-01 22:13:53
 */
@Data
public class Gushi implements Serializable {
    private static final long serialVersionUID = 517437962717661572L;
    
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 朝代
     */
    private String country;
    /**
     * 正文
     */
    private String content;
    /**
     * 翻译
     */
    private String tslt;
    /**
     * 备注
     */
    private String comment;
    /**
     * 赏析
     */
    private String appreciation;
    /**
     * 作者简介
     */
    private String introduce;


}

