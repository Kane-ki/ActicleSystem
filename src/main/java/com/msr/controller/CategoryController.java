package com.msr.controller;

import com.msr.pojo.Category;
import com.msr.pojo.entity.Result;
import com.msr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wjing
 * @create 2024-11-14 上午11:17
 * @desc
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 添加文章分类
     * @return
     */
    @PostMapping
    public Result addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return Result.success();
    }

    /**
     * 查询分类
     * @return
     */
    @GetMapping
    public Result<List<Category>> list(){
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
        Category category = categoryService.findById(id);
        return Result.success(category);
    }

    /**
     * 更新文章分类
     * @param category
     * @return
     */
    @PutMapping
    public Result updateCategory(@RequestBody @Validated Category category){
        categoryService.updateCategory(category);
        return Result.success();
    }

    @DeleteMapping
    public Result delCategory(Integer id){
        categoryService.delCategory(id);
        return Result.success();
    }
}
