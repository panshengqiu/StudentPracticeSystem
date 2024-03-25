package cn.edu.bjut.interceptor;

import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override  // controller方法执行前,false表示拦截，true表示放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        System.out.println("preHandle...");

        // 1. 获取请求资源路径
        String url = req.getRequestURI();

        // 2. 判断路径是否为登录路径
        if(url.contains("login")){
            // 是登录路径，放行
            log.info("登录路径，放行");
            return true;
        }
        // 3. 获取请求头的令牌
        String jwt = req.getHeader("token");
        // 4. 判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("未登录");
            Result result = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(result);
            resp.getWriter().write(notLogin);
            return false;
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
            return false;
        }

        // 6. 放行
        return true;
    }


    @Override  // controller方法执行后，视图渲染前
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle....");
    }

    @Override  // 视图渲染后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("after completion....");
    }
}
