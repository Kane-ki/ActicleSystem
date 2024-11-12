package com.msr.mapper;

import com.msr.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wjing
 * @create 2024-11-11 上午11:33
 * @desc
 */
@Mapper
public interface UserMapper {

    @Select("select  * from user where username=#{username}")
    User findByName(String username);

    @Insert("insert into user(username,password,create_time,update_time) values (#{username},#{password},now(),now())")
    void register(String username, String password);


}