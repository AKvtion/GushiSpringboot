package com.example.poetry.service.impl;

import com.example.poetry.base.entity.Echarts;
import com.example.poetry.entity.Gushi;
import com.example.poetry.dao.GushiDao;
import com.example.poetry.service.GushiService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Gushi)表服务实现类
 *
 * @author fauchard
 * @since 2023-01-01 22:13:53
 */
@Service("gushiService")
public class GushiServiceImpl implements GushiService {
    @Resource
    private GushiDao gushiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Gushi queryById(Integer id) {
        return this.gushiDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param gushi 实例对象
     * @return 实例对象
     */
    @Override
    public Gushi insert(Gushi gushi) {
        this.gushiDao.insert(gushi);
        return gushi;
    }

    /**
     * 修改数据
     *
     * @param gushi 实例对象
     * @return 实例对象
     */
    @Override
    public Gushi update(Gushi gushi) {
        this.gushiDao.update(gushi);
        return this.queryById(gushi.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.gushiDao.deleteById(id) > 0;
    }

    @Override
    public List<Gushi> queryAll() {
        return gushiDao.selectAll();
    }

    @Override
    public List<Gushi> queryByName(String name) {
        return gushiDao.queryByName(name);
    }

    @Override
    public List<Gushi> queryAuthor() {
        return gushiDao.queryAuthor();
    }

    @Override
    public List<Echarts> getCountryCount() {
        return gushiDao.getCountryCount();
    }


}
