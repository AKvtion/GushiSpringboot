package com.example.poetry.dao;

import com.example.poetry.entity.Sentence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Sentence)表数据库访问层
 *
 * @author fauchard
 * @since 2023-03-09 10:59:51
 */
public interface SentenceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sentence queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param sentence 查询条件
     * @return 总行数
     */
    long count(Sentence sentence);

    /**
     * 新增数据
     *
     * @param sentence 实例对象
     * @return 影响行数
     */
    int insert(Sentence sentence);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sentence> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sentence> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sentence> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Sentence> entities);

    /**
     * 修改数据
     *
     * @param sentence 实例对象
     * @return 影响行数
     */
    int update(Sentence sentence);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Sentence> queryAll();

    List<Sentence> queryByName(String name);
}

