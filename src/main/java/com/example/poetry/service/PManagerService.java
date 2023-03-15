package com.example.poetry.service;

import com.example.poetry.entity.PManager;

/**
 * (PManager)表服务接口
 *
 * @author fauchard
 * @since 2023-01-01 11:57:54
 */
public interface PManagerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PManager queryById(Integer id);


    /**
     * 新增数据
     *
     * @param pManager 实例对象
     * @return 实例对象
     */
    PManager insert(PManager pManager);

    /**
     * 修改数据
     *
     * @param pManager 实例对象
     * @return 实例对象
     */
    PManager update(PManager pManager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    PManager find(String username);

    int register(PManager pManager);
}
