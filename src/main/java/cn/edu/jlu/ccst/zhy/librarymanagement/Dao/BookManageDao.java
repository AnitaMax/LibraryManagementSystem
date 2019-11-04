package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import org.apache.ibatis.annotations.Insert;

public interface BookManageDao  {

    //增加书籍
    @Insert("insert into books(name,isbn,author,publisher,`describe`,location,num) values(#{name},#{isbn},#{author},#{publisher},#{describe},#{location},#{num})")
    int addBook(String name,String isbn,String describe,String author,String publisher,String location,int num);
}
