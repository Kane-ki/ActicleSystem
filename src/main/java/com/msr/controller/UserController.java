package com.msr.controller;

import com.msr.pojo.User;
import com.msr.pojo.entity.Result;
import com.msr.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjing
 * @create 2024-11-11 上午11:29
 * @desc
 */
@RestController//Controller + ResponseBody
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{3,10}$") String username,@Pattern(regexp = "^\\S{3,10}$") String password){
        //1.根据用户名查询用户的对象
       User user = userService.findByName(username);
        //2.判断用户对象是否存在（1.存在（不注册） 2.不存在（注册））
        if(user==null){
            //不存在，可以注册
            userService.register(username,password);
            return Result.success();
        }else {
            //存在，不可以注册
            return Result.error("注册失败，用户名存在");
        }

    }
}
