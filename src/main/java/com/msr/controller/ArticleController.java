package com.msr.controller;

import com.msr.pojo.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjing
 * @create 2024-11-12 上午10:17
 * @desc
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result list(){
        return Result.error("获取文章列表数据");
    }
}
