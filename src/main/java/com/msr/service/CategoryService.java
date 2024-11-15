package com.msr.service;

import com.msr.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    List<Category> list();

    Category findById(Integer id);

    void updateCategory(Category category);

    void delCategory(Integer id);
}
