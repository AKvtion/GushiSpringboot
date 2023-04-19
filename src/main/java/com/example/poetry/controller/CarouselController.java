package com.example.poetry.controller;

import com.example.poetry.base.config.Result;
import com.example.poetry.entity.Carousel;
import com.example.poetry.service.CarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carousel)表控制层
 *
 * @author fauchard
 * @since 2023-01-13 15:10:03
 */
@Api(tags = "轮播图模块")
@RestController
@RequestMapping("carousel")
public class CarouselController {
    /**
     * 服务对象
     */
    @Resource
    private CarouselService carouselService;

    /**
     * 分页查询
     * @return Result
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "80") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Carousel> carousels = carouselService.queryAll();
        PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
        return new Result().success(pageInfo);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("/queryById/{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        return new Result().success(this.carouselService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carousel 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping("/add")
    public Result add(Carousel carousel) {
        return new Result().success(this.carouselService.insert(carousel));
    }

    /**
     * 编辑数据
     *
     * @param carousel 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑数据")
    @PutMapping("/edit")
    public Result edit(Carousel carousel) {
        return new Result().success(this.carouselService.update(carousel));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping("/deleteById")
    public Result deleteById(Integer id) {
        return new Result().success(this.carouselService.deleteById(id));
    }

}

