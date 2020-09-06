package com.mybysj.springboot.Filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//字符过滤
@WebFilter(urlPatterns = "/*",filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType(request.getHeader("Accept").contains("text/html") ? "text/html;charset=utf-8" :   "text/css;charset=utf-8");
        filterChain.doFilter(request , response);
    }
    @Override
    public void destroy() {
    }
}

