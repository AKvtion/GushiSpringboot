package com.example.poetry.entity;


import lombok.Data;
import java.io.Serializable;

/**
 * (Carousel)实体类
 *
 * @author fauchard
 * @since 2023-01-13 15:10:03
 */
@Data
public class Carousel implements Serializable {
    private static final long serialVersionUID = 513674107453866613L;
    /**
     * 首页轮播图主键id
     */
    private Integer carouselId;
    /**
     * 轮播图
     */
    private String carouselUrl;
    /**
     * 点击后的跳转地址(默认不跳转)
     */
    private String redirectUrl;
    /**
     * 排序值(字段越大越靠前)
     */
    private Integer carouselRank;




}

