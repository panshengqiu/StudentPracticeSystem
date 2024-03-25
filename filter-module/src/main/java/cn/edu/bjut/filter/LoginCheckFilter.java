package cn.edu.bjut.filter;


import cn.edu.bjut.entity.Result;
import cn.edu.bjut.utils.JWTUtils;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1. 获取请求资源路径
        String url = req.getRequestURI();

        // 2. 判断路径是否为登录路径
        if(url.contains("login")){
            // 是登录路径，放行
            log.info("登录路径，放行");
            filterChain.doFilter(request, response);
            return;
        }
        // 3. 获取请求头的令牌
        String jwt = req.getHeader("token");
        // 4. 判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("未登录");
            Result result = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(result);
            resp.getWriter().write(notLogin);
            return;
        }

        // 5. 校验令牌
        try {
            JWTUtils.parseJWT();
        } catch (Exception e) { // 令牌校验失败
            e.printStackTrace();
            log.info("未登录");
            Result result = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(result);
            resp.getWriter().write(notLogin);
            return;
        }

        // 6. 放行
        filterChain.doFilter(request, response);

    }
}
