package com.mybysj.springboot.DaoInterface_JPA;

import com.mybysj.springboot.model.AuthorVo;
import com.mybysj.springboot.model.ReplyVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AReplyMapper_JPA extends JpaRepository<ReplyVo,Integer> {
    @Query(value = "select * from acomments  limit ?1,?2",nativeQuery = true)//分页查询
    List<ReplyVo> ASelectReplyVos(int PageNum, int PageSize);

    @Query(value = "delete from acomments where commentid=?1",nativeQuery = true)//按id删除
    @Modifying
    int ADeleteReplyVos(int id);

    @Query(value = "select distinct * from acomments where bookno like %?1% or commentid like %?2%",nativeQuery = true)//模糊查询
    List<ReplyVo> ASelectOneReplyVos(int bookno,int commentid);
}
