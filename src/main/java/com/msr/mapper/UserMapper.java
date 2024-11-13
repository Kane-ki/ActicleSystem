package com.msr.mapper;

import com.msr.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Update("update user set user_pic=#{userPic},update_time=now() where id=#{id}")
    void updateAvatar(String userPic,int id);
}
