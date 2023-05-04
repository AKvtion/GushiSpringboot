package com.example.poetry.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Validator;
import com.example.poetry.base.config.Result;
import com.example.poetry.entity.PManager;
import com.example.poetry.entity.PUser;
import com.example.poetry.service.PManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PManager)表控制层
 *
 * @author fauchard
 * @since 2023-01-01 11:57:52
 */
@Api(tags = "管理员模块")
@RestController
@RequestMapping("pManager")
public class PManagerController {
    /**
     * 服务对象
     */
    @Resource
    private PManagerService pManagerService;

    /**
     * 注册方法
     * @param pManager 实体
     * @return Result
     */
    @PostMapping("/register")
    public Result register(@RequestBody PManager pManager){
        String username = pManager.getUsername();
        String password = pManager.getPassword();
        PManager manager = pManagerService.find(username);
        if (manager != null){
            return new Result().fail("用户已经存在",400);
        }
        if (Validator.isEmpty(username)||Validator.isEmpty(password)){
            return new Result().fail("用户名或密码不能为空",400);
        }
        String userPassword = DigestUtils.md5Hex(password);
        pManager = new PManager();
        pManager.setUsername(username);
        pManager.setPassword(userPassword);
        System.out.println(userPassword);
        return new Result().success(pManagerService.register(pManager));
    }

    /**
     * 登录方法
     * @param pManager 实体
     * @return Result
     */
    @PostMapping("/login")
    @SaCheckLogin
    public Result login(@RequestBody PManager pManager){
        String username = pManager.getUsername();
        String password = pManager.getPassword();
        if (Validator.isEmpty(username)||Validator.isEmpty(password)){
            return new Result().fail("用户名或密码不能为空",400);
        }
        //加密后的字符串
        String usePassword = DigestUtils.md5Hex(password);
        pManager = pManagerService.find(username);
        //进行判断数据库是否有这个用户
        if(pManager == null){
            //如没有，返回错误消息
            return new Result().fail("用户不存在 登录失败",400);
        }
        Integer id = pManager.getId();
        String username1 = pManager.getUsername();
        //如果不为空，根据查询对象获取数据库的密码进行比对
        String pwd = pManager.getPassword();
        if (pwd.equals(usePassword) && username1.equals(username)){
            StpUtil.login(id);
            //获取登录生成的token
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            System.out.println(tokenInfo);
            Map<String,Object> map = new HashMap<>();
            map.put("username",username);
            map.put("token",tokenInfo);
            //匹配成功
            return new Result().success(map);
        }else {
            return new Result().fail("用户名或密码错误 登录失败",400);
        }
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        return new Result().success(this.pManagerService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @return Result
     */
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "80") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PManager> pManagers = pManagerService.queryAll();
        PageInfo<PManager> pageInfo = new PageInfo<>(pManagers);
        return new Result().success(pageInfo);
    }

    /**
     * 新增数据
     *
     * @param pManager 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PManager> add(PManager pManager) {
        return ResponseEntity.ok(this.pManagerService.insert(pManager));
    }

    /**
     * 编辑数据
     *
     * @param pManager 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PManager> edit(PManager pManager) {
        return ResponseEntity.ok(this.pManagerService.update(pManager));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.pManagerService.deleteById(id));
    }

    /*
     * 登录方法
     * @param pManager
     * @return
    @PostMapping("/login")
    @SaCheckLogin
    public Result login(@RequestBody PManager pManager){
        String username = pManager.getUsername();
        String password = pManager.getPassword();
        if (Validator.isEmpty(username)||Validator.isEmpty(password)){
            return new Result().fail("用户名或密码不能为空",400);
        }
        String usePassword = DigestUtils.md5Hex(password);
        pManager = pManagerService.find(username);
        //进行判断数据库是否有这个用户
        if(pManager == null){
            //如没有，返回错误消息
            return new Result().fail("用户不存在 登录失败",400);
        }
        //如果不为空，根据用户对象获取数据的密码
        String pwd = pManager.getPassword();
        Map<String,Object> map = new HashMap<>();
        //将数据库的密码和前端传进来的密码进行匹配
        if(pwd.equals(usePassword)){
            //生成JWT令牌
            String token = "admin";
            map.put("username",username);
            map.put("token",token);
            //匹配成功
            return new Result().success(map);
        } else {
            return new Result().fail("密码错误 登录失败",400);
        }
    }
     */
}

