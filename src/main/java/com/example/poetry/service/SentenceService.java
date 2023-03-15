package com.example.poetry.service;

import com.example.poetry.entity.Sentence;

import java.util.List;

/**
 * (Sentence)表服务接口
 *
 * @author fauchard
 * @since 2023-03-09 10:59:51
 */
public interface SentenceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sentence queryById(Integer id);

    /**
     * 新增数据
     *
     * @param sentence 实例对象
     * @return 实例对象
     */
    Sentence insert(Sentence sentence);

    /**
     * 修改数据
     *
     * @param sentence 实例对象
     * @return 实例对象
     */
    Sentence update(Sentence sentence);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Sentence> queryAll();

    List<Sentence> queryByName(String name);
}
