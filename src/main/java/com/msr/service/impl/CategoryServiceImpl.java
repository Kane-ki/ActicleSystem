package com.msr.service.impl;

import com.msr.mapper.CategoryMapper;
import com.msr.pojo.Category;
import com.msr.service.CategoryService;
import com.msr.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wjing
 * @create 2024-11-14 上午11:18
 * @desc
 */
@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
   private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id =(Integer) claims.get("id");  //用户id
        //设置create_user的字段
        category.setCreateUser(id);
        categoryMapper.addCategory(category);
    }

    //查询分类
    @Override
    public List<Category> list() {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id =(Integer) claims.get("id");  //用户id
        return categoryMapper.list(id);
    }

    //根据id查询详情
    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    //更新文章分类
    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    //删除分类
    @Override
    public void delCategory(Integer id) {
        categoryMapper.delCategory(id);
    }
}
