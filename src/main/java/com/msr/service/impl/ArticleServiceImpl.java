package com.msr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.msr.mapper.ArticleMapper;
import com.msr.pojo.Article;
import com.msr.pojo.entity.PageBean;
import com.msr.pojo.query.ArticleQuery;
import com.msr.service.ArticleService;
import com.msr.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wjing
 * @create 2024-11-14 下午1:43
 * @desc
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article) {
        //给用户id赋值
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);

        articleMapper.addArticle(article);
    }

    @Override
    public PageBean<Article> pageList(ArticleQuery articleQuery) {
       //1.开启分页的查询
        PageHelper.startPage(articleQuery.getPageNum(),articleQuery.getPageSize());
        //2.调用mapper的条件查询
        //给用户id赋值
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
       List<Article> articleList = articleMapper.pageList(userId,articleQuery.getCategoryId(),articleQuery.getState());
        //3.根据查询的集合数据转换为page的类型
        Page<Article> page = (Page<Article>)articleList;
        //4.把数据封装到PageBean对象当中
        PageBean<Article> pageBean = new PageBean<>(page.getTotal(),page.getResult());
        return pageBean;
    }
}
