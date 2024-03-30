package cn.edu.bjut.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")  // 拦截所有请求
public class FilterImpl implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("filter one 初始化方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter one拦截到了请求，放行前的逻辑");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("filter one 放行后的逻辑");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("filter one 销毁方法执行了");
    }
}
