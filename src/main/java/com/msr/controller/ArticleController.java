package com.msr.controller;

import com.msr.pojo.Article;
import com.msr.pojo.entity.PageBean;
import com.msr.pojo.entity.Result;
import com.msr.pojo.query.ArticleQuery;
import com.msr.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wjing
 * @create 2024-11-12 上午10:17
 * @desc
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Result list(){
        return Result.error("获取文章列表数据");
    }

    //新增文章
    @PostMapping
    public Result addArticle(@RequestBody Article article){

        articleService.addArticle(article);
        System.out.println(Result.success());
        return  Result.success();
    }

    //文章分页
    @GetMapping
    public Result<PageBean> pageList(ArticleQuery articleQuery){
        //调用业务处理
        PageBean<Article> pageBean =   articleService.pageList(articleQuery);
        return Result.success(pageBean);
    }
}
