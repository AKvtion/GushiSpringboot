package com.example.poetry.dao;

import com.example.poetry.entity.PUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PUser)表数据库访问层
 *
 * @author fauchard
 * @since 2023-01-12 16:41:51
 */
@Mapper
public interface PUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param pUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
    List<PUser> queryAllByLimit(PUser pUser, @Param("pageable") Pageable pageable);
     */

    /**
     * 统计总行数
     *
     * @param pUser 查询条件
     * @return 总行数
     */
    long count(PUser pUser);

    /**
     * 新增数据
     *
     * @param pUser 实例对象
     * @return 影响行数
     */
    int insert(PUser pUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PUser> entities);

    /**
     * 修改数据
     *
     * @param pUser 实例对象
     * @return 影响行数
     */
    int update(PUser pUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<PUser> selectAll();

    List<PUser> queryByName(String name);

    PUser selectOne(String username);
}

