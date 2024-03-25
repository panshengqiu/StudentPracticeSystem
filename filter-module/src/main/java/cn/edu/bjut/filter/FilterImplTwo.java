package cn.edu.bjut.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class FilterImplTwo implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter two拦截到了请求，放行前的逻辑");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("filter two 放行后的逻辑");
    }
}
