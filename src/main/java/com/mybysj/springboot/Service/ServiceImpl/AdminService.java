package com.mybysj.springboot.Service.ServiceImpl;


import com.mybysj.springboot.DaoInterface.AdminLogsDao;
import com.mybysj.springboot.model.LogVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Resource
    private AdminLogsDao adminLogsDao;

    //日志管理
    public List<LogVo> ASelectLogs(Map map){return adminLogsDao.ASelectLogs(map);};//查询所有评论
    public int ADeleteLogs(Map map){return adminLogsDao.ADeleteLogs(map);};//删除评论
}
