package com.msr.interceptors;

import com.msr.utils.JwtUtil;
import com.msr.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try{
            Map<String,Object> map = JwtUtil.parseToken(token);
            //保存数据
            ThreadLocalUtil.set(map);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}
