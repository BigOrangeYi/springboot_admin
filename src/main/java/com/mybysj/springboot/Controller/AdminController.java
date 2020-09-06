package com.mybysj.springboot.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybysj.springboot.DaoInterface.ReplyMapper;
import com.mybysj.springboot.DaoInterface_JPA.AReplyMapper_JPA;
import com.mybysj.springboot.DaoInterface_JPA.AuthorMapper_JPA;
import com.mybysj.springboot.DaoInterface_JPA.BookMapper_JPA;
import com.mybysj.springboot.DaoInterface_JPA.UserMapper_JPA;
import com.mybysj.springboot.Service.UserService;
import com.mybysj.springboot.model.AuthorVo;
import com.mybysj.springboot.model.BookVo;
import com.mybysj.springboot.model.ReplyVo;
import com.mybysj.springboot.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


@Controller
public class AdminController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserMapper_JPA userMapper_JPA;
    @Autowired
    private AuthorMapper_JPA authorMapper_jpa;
    @Autowired
    private BookMapper_JPA bookMapper_jpa;
    @Autowired
    private AReplyMapper_JPA aReplyMapper_jpa;
    @Resource
    private ReplyMapper replyMapper;


//----------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/login.do")//管理员登录
    public void login_do(HttpServletResponse response, @RequestBody Map map, HttpSession session) throws IOException {
        if (map.get("username")!=null&& map.get("password")!=null){

            String administrator=map.get("username").toString();
            String password=map.get("password").toString();

            if (administrator.equals("administrator")&& password.equals("55555"))
            {
                session.setAttribute("admin", administrator);
                objectMapper.writeValue(response.getWriter(), true);
            }else {
                objectMapper.writeValue(response.getWriter(), false);
            }

        }else {
            objectMapper.writeValue(response.getWriter(), false);
        }


    }
//-----------------------------------------------------------------------------------------------------------------
    @PostMapping("/ASelectAllUsers.do")//管理用户：查询所有用户功能
    public void ASelectAllUser(HttpServletResponse response, @RequestBody Map maps) throws IOException {
        int PageSize=Integer.parseInt(maps.get("PageSize").toString());
        int PageNum=(Integer.parseInt(maps.get("PageNum").toString())-1)*PageSize;
        objectMapper.writeValue(response.getWriter(), userMapper_JPA.ASelectUsers(PageNum,PageSize));
    }
    @Transactional
    @Rollback(value = false)
    @RequestMapping("/ADeleteUsers.do")//管理用户：删除用户功能
    public void ADeleteUsers(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        objectMapper.writeValue(response.getWriter(), userMapper_JPA.ADeleteUsers(Integer.parseInt(maps.get("id").toString())));
    }
    @RequestMapping("/AUpdateUsers.do")//管理用户：修改用户功能
    @Rollback(value = false)//管理用户：更新用户功能
    public void AUpdateUsers(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        UserVo userVo=new UserVo(Integer.parseInt(maps.get("id").toString()),maps.get("phone").toString(),maps.get("password").toString(),maps.get("readername").toString(),maps.get("headimg").toString());
        objectMapper.writeValue(response.getWriter(),userMapper_JPA.save(userVo));
    }
    @RequestMapping("ASelectOneUsers.do")//管理用户：模糊查询功能
    public void ASelectOneUsers(HttpServletResponse response,@RequestBody Map maps) throws Exception {
       if (maps.get("readername")!=null&&maps.get("readername").toString().trim()!="")
           if (maps.get("phone").toString().trim()!=""&&maps.get("phone")!=null)
        objectMapper.writeValue(response.getWriter(), userMapper_JPA.ASelectOneUsers(maps.get("phone").toString(),maps.get("readername").toString()));
    }
//-----------------------------------------------------------------------------------------------------------

    @PostMapping("/ASelectAuthors.do")//管理作者：查询所有作者功能
    public void ASelectAllAuthor(HttpServletResponse response, @RequestBody Map maps) throws IOException {
        int PageSize=Integer.parseInt(maps.get("PageSize").toString());
        int PageNum=(Integer.parseInt(maps.get("PageNum").toString())-1)*PageSize;
        objectMapper.writeValue(response.getWriter(), authorMapper_jpa.ASelectAuthors(PageNum,PageSize));
    }
    @Transactional
    @Rollback(value = false)
    @RequestMapping("/ADeleteAuthors.do")//管理作者：删除作者功能
    public void ADeleteAuthors(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        objectMapper.writeValue(response.getWriter(), authorMapper_jpa.ADeleteAuthors(Integer.parseInt(maps.get("authorno").toString())));
    }
    @RequestMapping("/AUpdateAuthors.do")//管理作者：修改作者功能
    @Rollback(value = false)
    public void AUpdateAuthors(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        AuthorVo authorVo=new AuthorVo(Integer.parseInt(maps.get("authorno").toString()),maps.get("phone").toString(),maps.get("authorname").toString());
        objectMapper.writeValue(response.getWriter(),authorMapper_jpa.save(authorVo));
    }
    @RequestMapping("/ASelectOneAuthors.do")//管理作者：模糊查询功能
    public void ASelectOneAuthors(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        if (maps.get("authorname")!=null&&maps.get("authorname").toString().trim()!="")
            if (maps.get("phone").toString().trim()!=""&&maps.get("phone")!=null)
                objectMapper.writeValue(response.getWriter(), authorMapper_jpa.ASelectOneAuthors(maps.get("phone").toString(),maps.get("authorname").toString()));
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------
@RequestMapping("ASelectBooks.do")//管理书籍：查询所有书籍功能
public void ASelectBooks(HttpServletResponse response, @RequestBody Map maps) throws Exception {
    int PageSize=Integer.parseInt(maps.get("PageSize").toString());
    int PageNum=(Integer.parseInt(maps.get("PageNum").toString())-1)*PageSize;
    objectMapper.writeValue(response.getWriter(), bookMapper_jpa.ASelectBooks(PageNum,PageSize));
}
    @RequestMapping("ASelectOneBooks.do")//管理书籍：模糊查询功能
    public void ASelectOneBooks(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        if (maps.get("authorname")!=null&&maps.get("authorname").toString().trim()!="")
            if (maps.get("bookname").toString().trim()!=""&&maps.get("bookname")!=null)
        objectMapper.writeValue(response.getWriter(), bookMapper_jpa.ASelectOneBooks(maps.get("bookname").toString(),maps.get("authorname").toString()));
    }
    @Transactional
    @Rollback(value = false)
    @RequestMapping("ADeleteBooks.do")//管理书籍：删除书籍功能
    public void ADeleteBooks(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        objectMapper.writeValue(response.getWriter(), bookMapper_jpa.ADeleteBooks(Integer.parseInt(maps.get("bookno").toString())));
    }
    @RequestMapping("AUpdateBooks.do")//管理书籍：修改书籍功能
    public void AUpdateBooks(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        BookVo bookVo=new BookVo();
        bookVo.setBookname(maps.get("bookname").toString());
        bookVo.setBookno(Integer.parseInt(maps.get("bookno").toString()));
        bookVo.setBookimg(maps.get("bookimg").toString());
        bookVo.setAuthorno(Integer.parseInt(maps.get("authorno").toString()));
        bookVo.setAuthorname(maps.get("bookname").toString());
        bookVo.setBookpopularity(Integer.parseInt(maps.get("bookpopularity").toString()));
        bookVo.setBookbirthday(maps.get("bookbirthday").toString());
        bookVo.setBookposition(maps.get("bookposition").toString());
        bookVo.setBookintro(maps.get("bookintro").toString());
        bookVo.setBooktype(maps.get("booktype").toString());
        bookVo.setBookpublish(Integer.parseInt(maps.get("bookpublish").toString()));
        objectMapper.writeValue(response.getWriter(),bookMapper_jpa.save(bookVo));
    }
    //----------------------------------------------------------------------------------------------------------------------
    @RequestMapping("ASelectReplys.do")//管理评论：查询所有评论功能
    public void ASelectReplys(HttpServletResponse response, @RequestBody Map maps) throws Exception {
        int PageSize=Integer.parseInt(maps.get("PageSize").toString());
        int PageNum=(Integer.parseInt(maps.get("PageNum").toString())-1)*PageSize;
        objectMapper.writeValue(response.getWriter(), aReplyMapper_jpa.ASelectReplyVos(PageNum,PageSize));
    }
    @RequestMapping("ASelectOneReplys.do")//管理评论：模糊查询功能
    public void ASelectOneReplys(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        if (maps.get("bookno")!=null&&maps.get("bookno").toString().trim()!="")
            if (maps.get("commentid").toString().trim()!=""&&maps.get("commentid")!=null)
                objectMapper.writeValue(response.getWriter(), replyMapper.ASelectOneReplyVos(Integer.parseInt(maps.get("bookno").toString()),Integer.parseInt(maps.get("commentid").toString())));
    }
    @Transactional
    @Rollback(value = false)
    @RequestMapping("ADeleteReplys.do")//管理评论：删除评论功能
    public void ADeleteReplys(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        objectMapper.writeValue(response.getWriter(), aReplyMapper_jpa.ADeleteReplyVos(Integer.parseInt(maps.get("commentid").toString())));
    }
    @RequestMapping("AUpdateReplys.do")//管理评论：修改评论功能
    public void AUpdateReplys(HttpServletResponse response,@RequestBody Map maps) throws Exception {
        ReplyVo replyVo = new ReplyVo();
        replyVo.setBookno(Integer.parseInt(maps.get("bookno").toString()));
        replyVo.setReplyid(Integer.parseInt(maps.get("replyid").toString()));
        replyVo.setCommentid(Integer.parseInt(maps.get("commentid").toString()));
        replyVo.setCommentdate(maps.get("commentdate").toString());
        replyVo.setCommenttext(maps.get("commenttext").toString());
        replyVo.setHeadimg(maps.get("headimg").toString());
        replyVo.setReadername(maps.get("readername").toString());
        replyVo.setReplyname(maps.get("replyname").toString());
        objectMapper.writeValue(response.getWriter(),aReplyMapper_jpa.save(replyVo));
    }
}
