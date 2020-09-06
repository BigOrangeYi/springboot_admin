package com.mybysj.springboot.Service;


import com.mybysj.springboot.model.UserVo;

import java.util.List;

public interface UserService {
    List<UserVo> findAll();
}
