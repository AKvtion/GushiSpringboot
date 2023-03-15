package com.example.poetry.service;

import com.example.poetry.entity.PUser;


import java.util.List;

/**
 * (PUser)表服务接口
 *
 * @author fauchard
 * @since 2023-01-12 16:41:51
 */
public interface PUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PUser queryById(Integer id);

    /**
     * 新增数据
     *
     * @param pUser 实例对象
     * @return 实例对象
     */
    PUser insert(PUser pUser);

    /**
     * 修改数据
     *
     * @param pUser 实例对象
     * @return 实例对象
     */
    PUser update(PUser pUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<PUser> queryAll();

    List<PUser> queryByName(String name);

    PUser find(String username);
}
