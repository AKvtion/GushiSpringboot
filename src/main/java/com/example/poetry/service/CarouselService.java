package com.example.poetry.service;

import com.example.poetry.entity.Carousel;

import java.util.List;


/**
 * (Carousel)表服务接口
 *
 * @author fauchard
 * @since 2023-01-13 15:10:03
 */
public interface CarouselService {

    /**
     * 通过ID查询单条数据
     *
     * @param carouselId 主键
     * @return 实例对象
     */
    Carousel queryById(Integer carouselId);


    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    Carousel insert(Carousel carousel);

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    Carousel update(Carousel carousel);

    /**
     * 通过主键删除数据
     *
     * @param carouselId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carouselId);

    List<Carousel> queryAll();
}
