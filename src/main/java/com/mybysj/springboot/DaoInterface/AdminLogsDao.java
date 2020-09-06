package com.mybysj.springboot.DaoInterface;


import com.mybysj.springboot.model.LogVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Mapper
public interface AdminLogsDao {
    List<LogVo> ASelectLogs(Map map);
    int ADeleteLogs(Map map);
}
