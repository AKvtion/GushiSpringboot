package com.example.poetry.service.impl;

import com.example.poetry.entity.PManager;
import com.example.poetry.dao.PManagerDao;
import com.example.poetry.service.PManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (PManager)表服务实现类
 *
 * @author fauchard
 * @since 2023-01-01 11:57:55
 */
@Service("pManagerService")
public class PManagerServiceImpl implements PManagerService {
    @Resource
    private PManagerDao pManagerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PManager queryById(Integer id) {
        return this.pManagerDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param pManager 实例对象
     * @return 实例对象
     */
    @Override
    public PManager insert(PManager pManager) {
        this.pManagerDao.insert(pManager);
        return pManager;
    }

    /**
     * 修改数据
     *
     * @param pManager 实例对象
     * @return 实例对象
     */
    @Override
    public PManager update(PManager pManager) {
        this.pManagerDao.update(pManager);
        return this.queryById(pManager.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.pManagerDao.deleteById(id) > 0;
    }

    @Override
    public PManager find(String username) {
        return pManagerDao.selectOne(username);
    }

    @Override
    public int register(PManager pManager) {
        return pManagerDao.register(pManager);
    }


}
