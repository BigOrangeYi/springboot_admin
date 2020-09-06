package com.mybysj.springboot.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest Request = (HttpServletRequest)request;
        HttpServletResponse Response = (HttpServletResponse)response;
        HttpSession session = Request.getSession(true);

        //安全过滤
        String fUrl = Request.getServletPath();
        //白名单放行
        String[] sUrl = {"/login"};
        String u = ((HttpServletRequest) request).getRequestURI();
        if(u.contains("fonts")||u.contains(".ico")||u.contains(".do")||u.contains(".css")||u.contains(".jpg")||u.contains(".png")||(u.contains(".js")&& (!u.contains("jsp"))))
        {//静态资源放行
            chain.doFilter(Request, Response);
            return;
        }
        for(String url : sUrl)
        {//白名单放行
            System.out.println("白名单url："+url);
            if(url.equals(fUrl))
            {
                chain.doFilter(Request, Response);
                return;
            }
        }

        String username = (String)session.getAttribute("admin");
        System.out.println("当前url:"+fUrl);

        if(username!=null){
            chain.doFilter(Request, Response);
        }else {
            System.out.println("url"+fUrl+"被拦截");
            Response.getWriter().print("<script>alert('请先登录');location.href='./login'</script>");
        }

    }

    @Override
    public void destroy() {

    }
}
