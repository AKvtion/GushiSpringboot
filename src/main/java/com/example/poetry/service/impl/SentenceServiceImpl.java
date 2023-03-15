package com.example.poetry.service.impl;

import com.example.poetry.entity.Sentence;
import com.example.poetry.dao.SentenceDao;
import com.example.poetry.service.SentenceService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (Sentence)表服务实现类
 *
 * @author fauchard
 * @since 2023-03-09 10:59:51
 */
@Service("sentenceService")
public class SentenceServiceImpl implements SentenceService {
    @Resource
    private SentenceDao sentenceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sentence queryById(Integer id) {
        return this.sentenceDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param sentence 实例对象
     * @return 实例对象
     */
    @Override
    public Sentence insert(Sentence sentence) {
        this.sentenceDao.insert(sentence);
        return sentence;
    }

    /**
     * 修改数据
     *
     * @param sentence 实例对象
     * @return 实例对象
     */
    @Override
    public Sentence update(Sentence sentence) {
        this.sentenceDao.update(sentence);
        return this.queryById(sentence.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sentenceDao.deleteById(id) > 0;
    }

    @Override
    public List<Sentence> queryAll() {
        return this.sentenceDao.queryAll();
    }

    @Override
    public List<Sentence> queryByName(String name) {
        return this.sentenceDao.queryByName(name);
    }
}
