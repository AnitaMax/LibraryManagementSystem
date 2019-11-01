package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BorrowLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonalCenterDao {

    //查看某个人借过但未还的书
   /* @Select("select * from books,(select bookid from borrowlog where userid=#{userid} and state='borrow') log where books.bookid=log.bookid")
    List<Book> getBorrowBooksByUserId(long userid);
    //查看某个人借过已经归还的书
    @Select("select * from books,(select bookid from borrowlog where userid=#{userid} and state='back') log where books.bookid=log.bookid")
    List<Book> getBackBooksByUserId(long userid);*/

    //查看某个人借过但未还的书
    @Select("select * from books,(select bookid,datetime borrowtime,state from borrowlog where userid=#{userid} and state='borrow') log where books.bookid=log.bookid")
    List<BookBorrowed> getBookBorrowedByUserId(long userid);
    //查看某个人借过但未还的书
    @Select("select * from books,(select bookid,datetime borrowtime,state from borrowlog where userid=#{userid} and state='borrow') log where books.bookid=log.bookid limit #{start},#{pagesize}")
    List<BookBorrowed> getBookBorrowedByUserIdPaged(long userid, int start, int pagesize);

    //查看某个人借过已经还的书
    @Select("select * from books,(select bookid,datetime borrowtime,state from borrowlog where userid=#{userid} and state='back') log where books.bookid=log.bookid")
    List<BookBorrowed> getBookBackedByUserId(long userid);
    //查看某个人借过已经还的书
    @Select("select * from books,(select bookid,datetime borrowtime,state from borrowlog where userid=#{userid} and state='back') log where books.bookid=log.bookid limit #{start},#{pagesize}")
    List<BookBorrowed> getBookBackedByUserIdPaged(long userid, int start, int pagesize);
}
