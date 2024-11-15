package com.msr.service;

import com.msr.pojo.Article;
import com.msr.pojo.entity.PageBean;
import com.msr.pojo.query.ArticleQuery;

public interface ArticleService {
    void addArticle(Article article);

    PageBean<Article> pageList(ArticleQuery articleQuery);
}
