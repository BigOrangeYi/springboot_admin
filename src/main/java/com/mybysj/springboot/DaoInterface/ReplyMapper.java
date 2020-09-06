package com.mybysj.springboot.DaoInterface;



import com.mybysj.springboot.model.ReplyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select(value = "select distinct * from acomments where bookno like '%${bookno}%' or commentid like '%${commentid}%'")//模糊查询
    List<ReplyVo> ASelectOneReplyVos(@Param("bookno") int bookno, @Param("commentid")int commentid);
}
