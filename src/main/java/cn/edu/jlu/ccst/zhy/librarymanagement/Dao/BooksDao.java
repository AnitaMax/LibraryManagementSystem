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
    @Select("select * from books where isbn=#{isbn}")
    List<Book> searchBooksByIsbn(String isbn);
    @Select("select * from books where bookid=#{isbn}")
    Book searchBooksByBookId(long isbn);
    //更新日志
    @Select("select * from borrowlog where userid=#{userid}")
    List<BorrowLog> getBorrowLogByUserId(long userid);
    @Select("select * from borrowlog where userid=#{userid} and bookid=#{bookid}")
    List<BorrowLog> getBorrowLogByUserIdAndBookId(long userid,long bookid);
    @Insert("insert into borrowlog values(#{userid},#{bookid},'borrow',1,#{date},'borrow')")
    void addBorrowLog(long userid, long bookid, Date date);
    @Insert("insert into borrowlog values(#{userid},#{bookid},'back',1,#{date},'done')")
    void addBackLog(long userid, long bookid, Date date);
    @Update("update borrowlog set state='back' where userid=#{userid} and bookid=#{bookid}")
    void updateBackLog(long userid, long bookid, Date date);

}
