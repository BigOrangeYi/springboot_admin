package com.mybysj.springboot.DaoInterface_JPA;

import com.mybysj.springboot.model.BookVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookMapper_JPA extends JpaRepository<BookVo,Integer> {
    @Query(value = "select * from abooks  limit ?1,?2",nativeQuery = true)//分页查询
    List<BookVo> ASelectBooks(int PageNum, int PageSize);
    @Query(value = "delete from abooks where bookno=?1",nativeQuery = true)//按id删除
    @Modifying
    int ADeleteBooks(int id);
    @Query(value = "select distinct * from abooks where bookname like %?1% or authorname like %?2%",nativeQuery = true)//模糊查询
    List<BookVo> ASelectOneBooks(String bookname,String authorname);
}
