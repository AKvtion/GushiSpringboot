package com.example.poetry.service.impl;

import com.example.poetry.entity.Carousel;
import com.example.poetry.dao.CarouselDao;
import com.example.poetry.service.CarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carousel)表服务实现类
 *
 * @author fauchard
 * @since 2023-01-13 15:10:03
 */
@Service("carouselService")
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselDao carouselDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carouselId 主键
     * @return 实例对象
     */
    @Override
    public Carousel queryById(Integer carouselId) {
        return this.carouselDao.queryById(carouselId);
    }


    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    @Override
    public Carousel insert(Carousel carousel) {
        this.carouselDao.insert(carousel);
        return carousel;
    }

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    @Override
    public Carousel update(Carousel carousel) {
        this.carouselDao.update(carousel);
        return this.queryById(carousel.getCarouselId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carouselId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carouselId) {
        return this.carouselDao.deleteById(carouselId) > 0;
    }

    @Override
    public List<Carousel> queryAll() {
        return this.carouselDao.queryAll();
    }
}
