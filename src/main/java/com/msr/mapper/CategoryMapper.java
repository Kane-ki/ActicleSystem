package com.msr.mapper;

import com.msr.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CategoryMapper {
    @Insert("insert into category values (null,#{categoryName},#{categoryAlias},#{createUser},now(),now())")
    void addCategory(Category category);

    @Select("select * from category where create_user=#{id}")
    List<Category> list(Integer id);

    @Select("select * from category where id=#{id}")
    Category findById(Integer id);

    @Update("update category set category_name=#{categoryName},category_alias =#{categoryAlias},update_time=now() where id=#{id}")
    void updateCategory(Category category);

    @Delete("delete from category where id=#{id}")
    void delCategory(Integer id);
}
