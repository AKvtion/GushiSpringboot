package com.example.poetry.dao;

import com.example.poetry.entity.Carousel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Carousel)表数据库访问层
 *
 * @author fauchard
 * @since 2023-01-13 15:10:03
 */
@Mapper
public interface CarouselDao {

    /**
     * 通过ID查询单条数据
     *
     * @param carouselId 主键
     * @return 实例对象
     */
    Carousel queryById(Integer carouselId);


    /**
     * 统计总行数
     *
     * @param carousel 查询条件
     * @return 总行数
     */
    long count(Carousel carousel);

    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 影响行数
     */
    int insert(Carousel carousel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carousel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Carousel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carousel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Carousel> entities);

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 影响行数
     */
    int update(Carousel carousel);

    /**
     * 通过主键删除数据
     *
     * @param carouselId 主键
     * @return 影响行数
     */
    int deleteById(Integer carouselId);

    List<Carousel> queryAll();
}

