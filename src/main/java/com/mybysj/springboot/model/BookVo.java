package com.mybysj.springboot.model;





import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "abooks")
public class BookVo implements Serializable,Cloneable,Comparable<BookVo> {
    @Id
    @Column(name = "bookno")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bookno;
    @Column(name = "authorno")
    private int authorno;
    @Column(name = "authorname")
    private String authorname;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "booktype")
    private String booktype;
    @Column(name = "bookimg")
    private String bookimg;
    @Column(name = "bookintro")
    private String bookintro;
    @Column(name = "bookpopularity")
    private double bookpopularity;
    @Column(name = "bookpublish")
    private int bookpublish;
    @Column(name = "bookbirthday")
    private String bookbirthday;
    @Column(name = "bookposition")
    private String bookposition;
    public  Object clone() throws  CloneNotSupportedException{
        return super.clone();
    }
    public BookVo() {
    }

    public BookVo(int bookno) {
        this.bookno = bookno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookVo)) return false;
        BookVo bookVo = (BookVo) o;
        return getBookno() == bookVo.getBookno() &&
                getAuthorno() == bookVo.getAuthorno() &&
                Double.compare(bookVo.getBookpopularity(), getBookpopularity()) == 0 &&
                getBookpublish() == bookVo.getBookpublish() &&
                getAuthorname().equals(bookVo.getAuthorname()) &&
                getBookname().equals(bookVo.getBookname()) &&
                getBooktype().equals(bookVo.getBooktype()) &&
                getBookimg().equals(bookVo.getBookimg()) &&
                getBookintro().equals(bookVo.getBookintro()) &&
                getBookbirthday().equals(bookVo.getBookbirthday()) &&
                getBookposition().equals(bookVo.getBookposition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookno(), getAuthorno(), getAuthorname(), getBookname(), getBooktype(), getBookimg(), getBookintro(), getBookpopularity(), getBookpublish(), getBookbirthday(), getBookposition());
    }

    public String getBookposition() {
        return bookposition;
    }

    public void setBookposition(String bookposition) {
        this.bookposition = bookposition;
    }

    public BookVo(int bookno, int authorno, String authorname, String bookname, String booktype, String bookimg, String bookintro, double bookpopularity, int bookpublish, String bookbirthday, String bookposition) {
        this.bookno = bookno;
        this.authorno = authorno;
        this.authorname = authorname;
        this.bookname = bookname;
        this.booktype = booktype;
        this.bookimg = bookimg;
        this.bookintro = bookintro;
        this.bookpopularity = bookpopularity;
        this.bookpublish = bookpublish;
        this.bookbirthday = bookbirthday;
        this.bookposition = bookposition;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "bookno=" + bookno +
                ", authorno=" + authorno +
                ", authorname='" + authorname + '\'' +
                ", bookname='" + bookname + '\'' +
                ", booktype='" + booktype + '\'' +
                ", bookimg='" + bookimg + '\'' +
                ", bookintro='" + bookintro + '\'' +
                ", bookpopularity=" + bookpopularity +
                ", bookpublish='" + bookpublish + '\'' +
                ", bookbirthday='" + bookbirthday + '\'' +
                ", bookposition='" + bookposition + '\'' +
                '}';
    }

    public int getBookno() {
        return bookno;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public int getAuthorno() {
        return authorno;
    }

    public void setAuthorno(int authorno) {
        this.authorno = authorno;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public String getBookintro() {
        return bookintro;
    }

    public void setBookintro(String bookintro) {
        this.bookintro = bookintro;
    }

    public double getBookpopularity() {
        return bookpopularity;
    }

    public void setBookpopularity(double bookpopularity) {
        this.bookpopularity = bookpopularity;
    }

    public int getBookpublish() {
        return bookpublish;
    }

    public void setBookpublish(int bookpublish) {
        this.bookpublish = bookpublish;
    }

    public String getBookbirthday() {
        return bookbirthday;
    }

    public void setBookbirthday(String bookbirthday) {
        this.bookbirthday = bookbirthday;
    }



    @Override
    public int compareTo(BookVo o) {
        return (int) (o.getBookpopularity()-this.getBookpopularity());
    }
}
