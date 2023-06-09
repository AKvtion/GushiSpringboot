package com.example.poetry.controller;


import com.example.poetry.base.config.Result;
import com.example.poetry.base.entity.Echarts;
import com.example.poetry.entity.Gushi;
import com.example.poetry.service.GushiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Gushi)表控制层
 *
 * @author fauchard
 * @since 2023-01-01 22:13:53
 */
@Api(tags = "古诗模块")
@RestController
@RequestMapping("gushi")
public class GushiController {
    /**
     * 服务对象
     */
    @Resource
    private GushiService gushiService;


    /**
     * 分页查询(后台)
     * @param pageNum 条数
     * @param pageSize 页数
     * @return Result
     */
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "80") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Gushi> gushis = gushiService.queryAll();
        PageInfo<Gushi> pageInfo = new PageInfo<>(gushis);
        return new Result().success(pageInfo);
    }

    /**
     * 通过作者查询记录
     *
     * @param name 作者名
     * @return Result
     */
    @GetMapping("/queryByName")
    public Result queryByName(@RequestParam("name") String name){
        List<Gushi> gushis = gushiService.queryByName(name);
        int total = (int) gushis.stream().count();
        Map<String,Object> map = new HashMap<>();
        map.put("data",gushis);
        map.put("total",total);
        return new Result().success(map);
    }

    /**
     * 查询所有记录，没有使用 PageHelper分页
     * @return Result
     */
    @GetMapping("/query")
    public Result query() {
        return new Result().success(gushiService.queryAll());
    }

    /**
     * 查询作者详细介绍，没有使用PageHelper分页
     * @return Result
     */
    @GetMapping("/queryAuthor")
    public Result queryAuthor() {
        return new Result().success(gushiService.queryAuthor());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        return new Result().success(this.gushiService.queryById(id));
    }
    /**
     * 分页查询(部分)
     *
     * @param pageNum 条数
     * @param pageSize 页数
     * @return Result
     */
    @GetMapping("/queryBuFen")
    public Result queryBuFen(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Gushi> gushis = gushiService.queryAll();
        PageInfo<Gushi> pageInfo = new PageInfo<>(gushis);
        return new Result().success(pageInfo);
    }

    /**
     * 新增数据
     * @param gushi 实体
     * @return Result
     */
    @PostMapping("/add")
    public Result add(Gushi gushi) {
        return new Result().success(this.gushiService.insert(gushi));
    }

    /**
     * 编辑数据
     * @param gushi 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public Result edit(Gushi gushi) {
        return new Result().success(this.gushiService.update(gushi));
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteById")
    public Result deleteById(Integer id) {
        return new Result().success(this.gushiService.deleteById(id));
    }

    /**
     * 获取每个朝代出现的次数
     * @return List
     */
    @GetMapping("/getCountry")
    public Result getCountyCount(){
        List<Echarts> echarts = this.gushiService.getCountryCount();
        Map<String,Object> maps = new HashMap<>();
        maps.put("series",echarts);
        return new Result().success(maps);
    }

    /**
     * 获取所有古诗文章总数量
     * @return List
     */
    @GetMapping("/getContent")
    public Result getContentCount(){
        Echarts echarts = this.gushiService.getContentCount();
        Map<String,Object> maps = new HashMap<>();
        maps.put("series",echarts);
        return new Result().success(maps);
    }
}

