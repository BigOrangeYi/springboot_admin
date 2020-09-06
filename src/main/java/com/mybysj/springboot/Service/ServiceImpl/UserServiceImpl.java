package com.mybysj.springboot.Service.ServiceImpl;

import com.mybysj.springboot.DaoInterface.UserMapper;
import com.mybysj.springboot.DaoInterface_JPA.UserMapper_JPA;
import com.mybysj.springboot.Service.UserService;
import com.mybysj.springboot.model.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private  UserMapper_JPA userMapper_jpa;

    @Override
    public List<UserVo> findAll() {
        return userMapper.findAll();
    }
}
