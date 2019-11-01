package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BorrowLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.Date;
import java.util.List;

public interface BooksDao {
    //搜索书
    @Select("select * from books where name like CONCAT('%',#{name},'%') ")
    List<Book> searchBooksByName(String name);
    @Select("select * from books where author like CONCAT('%',#{author},'%') ")
    List<Book> searchBooksByAuthor(String author);
    @Select("select * from books where author like CONCAT('%',#{content},'%') or name like CONCAT('%',#{content},'%')  or isbn=#{content}")
    List<Book> searchBooks(String content);
    @Select("select * from books where author like CONCAT('%',#{content},'%') or name like CONCAT('%',#{content},'%')  or isbn=#{content} limit #{start},#{pagesize}")
    List<Book> searchBooksByPage(String content ,int start,int pagesize);
    @Select("select * from books where isbn=#{isbn}")
    List<Book> searchBooksByIsbn(String isbn);
    @Select("select * from books where bookid=#{isbn}")
    Book searchBooksByBookId(long isbn);

    @Update("update books set num=num+#{num} where bookid=#{bookid}")
    void updateBookNumById(long bookid,int num);
    //借书
    @Insert("insert into borrowlog values(#{userid},#{bookid},'borrow',1,#{date},'borrow')")
    void addBorrowLog(long userid, long bookid, Date date);


    //归还
    @Insert("insert into borrowlog values(#{userid},#{bookid},'back',1,#{date},'done')")
    void addBackLog(long userid, long bookid, Date date);
    @Update("update borrowlog set state='back' where userid=#{userid} and bookid=#{bookid} and state='borrow'")
    void updateBackLog(long userid, long bookid);

    //查询状态
    @Select("select state from borrowlog where userid=#{userid} and bookid=#{bookid}")
    List<String> getStateByUseridAndBookid(long userid,long bookid);

}
