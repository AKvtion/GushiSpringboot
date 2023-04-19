package com.example.poetry.controller;

import com.example.poetry.base.config.Result;
import com.example.poetry.entity.Sentence;
import com.example.poetry.service.SentenceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Sentence)表控制层
 *
 * @author fauchard
 * @since 2023-03-09 10:59:51
 */
@Api(tags = "名言模块")
@RestController
@RequestMapping("sentence")
public class SentenceController {
    /**
     * 服务对象
     */
    @Resource
    private SentenceService sentenceService;

    /**
     * 分页查询(后台)
     *
     * @param pageNum 条数
     * @param pageSize 页数
     * @return Result
     */
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "80") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Sentence> sentences = sentenceService.queryAll();
        PageInfo<Sentence> pageInfo = new PageInfo<>(sentences);
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
        List<Sentence> sentences = sentenceService.queryByName(name);
        int total;
        for (total = 0; total < sentences.size(); total++) {
            total++;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",sentences);
        map.put("total",total);
        return new Result().success(map);
    }

    /**
     * 查询所有记录，没有使用PageHelper分页
     * @return Result
     */
    @GetMapping("/query")
    public Result query() {
        return new Result().success(sentenceService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        return new Result().success(this.sentenceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sentence 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result add(Sentence sentence) {
        return new Result().success(this.sentenceService.insert(sentence));
    }

    /**
     * 编辑数据
     *
     * @param sentence 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public Result edit(Sentence sentence) {
        return new Result().success(this.sentenceService.update(sentence));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteById")
    public Result deleteById(Integer id) {
        return new Result().success(this.sentenceService.deleteById(id));
    }

}

