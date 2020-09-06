package com.mybysj.springboot.DaoInterface_JPA;
import com.mybysj.springboot.model.AuthorVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorMapper_JPA extends JpaRepository<AuthorVo,Integer> {
    @Query(value = "select * from aauthors  limit ?1,?2",nativeQuery = true)//分页查询
    List<AuthorVo> ASelectAuthors(int PageNum, int PageSize);

    @Query(value = "delete from aauthors where authorno=?1",nativeQuery = true)//按id删除
    @Modifying
    int ADeleteAuthors(int id);

    @Query(value = "select distinct * from aauthors where phone like %?1% or authorname like %?2%",nativeQuery = true)//模糊查询
    List<AuthorVo> ASelectOneAuthors(String phone,String authorname);
}
