package com.example.poetry.dao;

import com.example.poetry.entity.PManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * (PManager)表数据库访问层
 *
 * @author fauchard
 * @since 2023-01-01 11:58:03
 */
@Mapper
public interface PManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PManager queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param pManager 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PManager> queryAllByLimit(PManager pManager, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pManager 查询条件
     * @return 总行数
     */
    long count(PManager pManager);

    /**
     * 新增数据
     *
     * @param pManager 实例对象
     * @return 影响行数
     */
    int insert(PManager pManager);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PManager> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PManager> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PManager> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PManager> entities);

    /**
     * 修改数据
     *
     * @param pManager 实例对象
     * @return 影响行数
     */
    int update(PManager pManager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 用户名查询
     * @param username
     * @return
     */
    PManager selectOne(String username);

    /**
     * 注册方法（用户名和密码）
     * @param pManager
     * @return
     */
    int register(PManager pManager);
}

