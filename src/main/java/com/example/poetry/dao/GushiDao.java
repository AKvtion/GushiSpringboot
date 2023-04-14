package com.example.poetry.dao;

import com.example.poetry.base.entity.Echarts;
import com.example.poetry.entity.Gushi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


/**
 * (Gushi)表数据库访问层
 *
 * @author fauchard
 * @since 2023-01-01 22:13:53
 */
@Mapper
public interface GushiDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Gushi queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param gushi 查询条件
     * @return 总行数
     */
    long count(Gushi gushi);

    /**
     * 新增数据
     *
     * @param gushi 实例对象
     * @return 影响行数
     */
    int insert(Gushi gushi);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Gushi> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Gushi> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Gushi> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Gushi> entities);

    /**
     * 修改数据
     *
     * @param gushi 实例对象
     * @return 影响行数
     */
    int update(Gushi gushi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Gushi> selectAll();

    List<Gushi> queryByName(String name);

    List<Gushi> queryAuthor();

    List<Echarts> getCountryCount();

}

