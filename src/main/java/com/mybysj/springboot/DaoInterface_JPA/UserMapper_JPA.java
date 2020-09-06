package com.mybysj.springboot.DaoInterface_JPA;

import com.mybysj.springboot.model.AuthorVo;
import com.mybysj.springboot.model.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMapper_JPA extends JpaRepository<UserVo,Integer> {
    @Query(value = "select * from ausers  limit ?1,?2",nativeQuery = true)//分页查询
    List<UserVo>  ASelectUsers(int PageNum,int PageSize);
    @Query(value = "delete from ausers where id=?1",nativeQuery = true)//按id删除
    @Modifying
    int ADeleteUsers(int id);
    @Query(value = "select distinct * from ausers where phone like %?1% or readername like %?2%",nativeQuery = true)//模糊查询
    List<UserVo> ASelectOneUsers(String phone,String readername);
//---------------------------------------------------------------------------------------------------------------------------


}
