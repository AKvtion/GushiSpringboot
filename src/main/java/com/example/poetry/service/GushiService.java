package com.example.poetry.service;

import com.example.poetry.base.entity.Echarts;
import com.example.poetry.base.entity.PageRequest;
import com.example.poetry.entity.Gushi;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * (Gushi)表服务接口
 *
 * @author fauchard
 * @since 2023-01-01 22:13:53
 */
public interface GushiService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Gushi queryById(Integer id);


    /**
     * 新增数据
     *
     * @param gushi 实例对象
     * @return 实例对象
     */
    Gushi insert(Gushi gushi);

    /**
     * 修改数据
     *
     * @param gushi 实例对象
     * @return 实例对象
     */
    Gushi update(Gushi gushi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    //查询所有
    List<Gushi> queryAll();

    List<Gushi> queryByName(String name);

    //查询作者详细
    List<Gushi> queryAuthor();

    List<Echarts> getCountryCount();

    Echarts getContentCount();
}
