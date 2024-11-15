package com.msr.interceptors;

import com.msr.utils.JwtUtil;
import com.msr.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @author wjing
 * @create 2024-11-12 下午2:49
 * @desc
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try{
            Map<String,Object> map = JwtUtil.parseToken(token);
            //保存数据
            ThreadLocalUtil.set(map);
            //判断redis中是否存在token
            String redisToken = redisTemplate.opsForValue().get(token);
            if(redisToken == null){
                //抛出异常
                throw new RuntimeException();
            }
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}
