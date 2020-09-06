package com.mybysj.springboot.DaoInterface;

import com.mybysj.springboot.model.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> findAll();
}
