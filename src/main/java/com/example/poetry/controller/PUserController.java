package com.example.poetry.controller;

import cn.hutool.core.lang.Validator;
import com.example.poetry.base.config.Result;
import com.example.poetry.entity.PUser;
import com.example.poetry.service.PUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PUser)表控制层
 *
 * @author fauchard
 * @since 2023-01-12 16:41:51
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("pUser")
public class PUserController {
    /**
     * 服务对象
     */
    @Resource
    private PUserService pUserService;

    /**
     * 分页查询
     *
     * @return Result
     */
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "80") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PUser> pUsers = pUserService.queryAll();
        PageInfo<PUser> pageInfo = new PageInfo<>(pUsers);
        return new Result().success(pageInfo);
    }

    /**
     * 通过用户名查询记录
     *
     * @param name 名字
     * @return Result
     */
    @GetMapping("/queryByName")
    public Result queryByName(@RequestParam("name") String name){
        List<PUser> pUsers = pUserService.queryByName(name);
        int total = (int) pUsers.stream().count();  // Java 8 的流式操作
//        int total;
//        for (total = 0; total < pUsers.size(); total++) {
//            total++;
//        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",pUsers);
        map.put("total",total);
        return new Result().success(map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        return new Result().success(this.pUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param pUser 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result add(PUser pUser) {
        String username = pUser.getUsername();
        String password = pUser.getPassword();
        String email = pUser.getEmail();
        String phone = pUser.getPhone();
        String status = pUser.getStatus();
        PUser u = pUserService.find(username);
        if (u != null){
            return new Result().fail("用户已经存在",400);
        }
        if (Validator.isEmpty(username)||Validator.isEmpty(password)){
            return new Result().fail("用户名或密码不能为空",400);
        }
        String userPassword = DigestUtils.md5Hex(password);
        pUser = new PUser();
        pUser.setUsername(username);
        pUser.setPassword(userPassword);
        pUser.setEmail(email);
        pUser.setPhone(phone);
        pUser.setStatus(status);
        System.out.println(userPassword);
        return new Result().success(this.pUserService.insert(pUser));
    }

    /**
     * 编辑数据
     *
     * @param pUser 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public Result edit(PUser pUser) {
        return new Result().success(this.pUserService.update(pUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("deleteById")
    public Result deleteById(Integer id) {
        return new Result().success(this.pUserService.deleteById(id));
    }

}

