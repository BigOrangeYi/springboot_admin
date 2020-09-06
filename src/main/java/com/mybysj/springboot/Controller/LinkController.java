package com.mybysj.springboot.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybysj.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LinkController {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/adminIndex")//进入管理首页
    public String adminIndex(){
        return "/adminIndex";
    }

    @RequestMapping("/login")
    public String login(HttpSession session){
        session.invalidate();
        return "/login";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "/hello";
    }


}

