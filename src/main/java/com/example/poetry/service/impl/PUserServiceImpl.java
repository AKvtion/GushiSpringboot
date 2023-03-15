package com.example.poetry.service.impl;

import com.example.poetry.entity.PUser;
import com.example.poetry.dao.PUserDao;
import com.example.poetry.service.PUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PUser)表服务实现类
 *
 * @author fauchard
 * @since 2023-01-12 16:41:51
 */
@Service("pUserService")
public class PUserServiceImpl implements PUserService {
    @Resource
    private PUserDao pUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PUser queryById(Integer id) {
        return this.pUserDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param pUser 实例对象
     * @return 实例对象
     */
    @Override
    public PUser insert(PUser pUser) {
        this.pUserDao.insert(pUser);
        return pUser;
    }

    /**
     * 修改数据
     *
     * @param pUser 实例对象
     * @return 实例对象
     */
    @Override
    public PUser update(PUser pUser) {
        pUser.setPassword(DigestUtils.md5Hex(pUser.getPassword()));
        this.pUserDao.update(pUser);
        return this.queryById(pUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.pUserDao.deleteById(id) > 0;
    }

    @Override
    public List<PUser> queryAll() {
        return this.pUserDao.selectAll();
    }

    @Override
    public List<PUser> queryByName(String name) {
        return this.pUserDao.queryByName(name);
    }

    @Override
    public PUser find(String username) {
        return this.pUserDao.selectOne(username);
    }
}
