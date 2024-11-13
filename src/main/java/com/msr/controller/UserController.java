package com.msr.controller;

import com.msr.pojo.User;
import com.msr.pojo.entity.Result;
import com.msr.service.UserService;
import com.msr.utils.JwtUtil;
import com.msr.utils.Md5Util;
import com.msr.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    //登录功能
    @PostMapping("/login")
    public Result<String> login(String username,String password){
        //登陆的业务代码
        //1.根据用户名查询用户对象
        User user = userService.findByName(username);
        //2.判断用户是否存在
        if(user==null){
            return Result.error("用户名不存在");
        }
        //3.判断密码是否正确
        if (Md5Util.getMD5String(password).equals(user.getPassword())){
            //当登陆成功之后，则生成token令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("username",user.getUsername());
           String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码出错");
    }
    @GetMapping("/userInfo")
    public  Result<User> userInfo(){
        //1.获取map中集合的数据
        Map<String,Object> map = ThreadLocalUtil.get();
        //2.根据username获取用户对象
        String username =(String) map.get("username");
        User user = userService.findByName(username);
        //3.返回响应数据
        return  Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return  Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }
}
