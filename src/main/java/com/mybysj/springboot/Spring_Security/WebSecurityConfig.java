package com.mybysj.springboot.Spring_Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 登录处理
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启登录配置
        http.authorizeRequests()
                // 标识访问 `/index` 这个接口，需要具备`ADMIN`角色
                .antMatchers("/admin").hasRole("ADMIN")
                // 允许匿名的url - 可理解为放行接口 - 多个接口使用,分割
                .antMatchers( "/login.html","/login1").permitAll()
                // 其余所有请求都需要认证
                .anyRequest().authenticated()
                .and()
                // 设置登录认证页面
                .formLogin().loginPage("/login.html")
                // 登录成功后的处理接口 - 方式①
                .loginProcessingUrl("/hello")
                // 自定义登陆用户名和密码属性名，默认为 username和password
                .usernameParameter("username")
                .passwordParameter("password")
                // 登录成功后的处理器  - 方式②
//                .successHandler((req, resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write("登录成功...");
//                    out.flush();
//                })
                // 配置登录失败的回调
                .failureHandler((req, resp, exception) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("登录失败...");
                    out.flush();
                })
                .permitAll()//和表单登录相关的接口统统都直接通过
                .and()
                .logout().logoutUrl("/logout")
                // 配置注销成功的回调
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("注销成功...");
                    out.flush();
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                // 关闭CSRF跨域
                .csrf().disable();

    }

    /**
     * 忽略拦截
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略url - 会直接过滤该url - 将不会经过Spring Security过滤器链
    /*    web.ignoring().antMatchers("/login.html");*/
        // 配置忽略js、css、images静态文件
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

}