package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowManageDao {
    //超期管理日志
    @Select("SELECT * FROM borrowlog,users,books WHERE state='borrow' AND DATE_SUB(CURDATE(),INTERVAL 15 DAY)>`datetime` AND users.userid=borrowlog.userid AND books.bookid=borrowlog.bookid")
    @Results({
            @Result(property = "borrowtime",  column = "datetime"),
    })
    List<BookBorrowed> getOverTimeLog();
    @Select("SELECT * FROM borrowlog,users,books WHERE state='borrow' AND DATE_SUB(CURDATE(),INTERVAL 15 DAY)>`datetime` AND users.userid=borrowlog.userid AND books.bookid=borrowlog.bookid order by borrowlog.datetime desc limit #{start},#{pagesize} ")
    @Results({
            @Result(property = "borrowtime",  column = "datetime"),
    })
    List<BookBorrowed> getOverTimeLogPaged(int start,int pagesize);
    //借阅日志
    @Select("SELECT * FROM borrowlog,users,books WHERE   users.userid=borrowlog.userid AND books.bookid=borrowlog.bookid")
    @Results({
            @Result(property = "borrowtime",  column = "datetime"),
    })
    List<BookBorrowed> getBorrowLog();

    @Select("SELECT * FROM borrowlog,users,books WHERE  users.userid=borrowlog.userid AND books.bookid=borrowlog.bookid order by borrowlog.datetime desc limit #{start},#{pagesize} ")
    @Results({
            @Result(property = "borrowtime",  column = "datetime"),
    })
    List<BookBorrowed> getBorrowLogPaged(int start,int pagesize);
}
