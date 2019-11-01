package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.PersonalCenterDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalCenterService {
    @Autowired
    PersonalCenterDao personalCenterDao;
    public List<BookBorrowed> getBorrowBooksByUserId(long userid){
        return personalCenterDao.getBookBorrowedByUserId(userid);
    }
    public List<BookBorrowed> getBackBooksByUserId(long userid){
        return personalCenterDao.getBookBackedByUserId(userid);
    }
    public List<BookBorrowed> getBorrowBooksByUserId(long userid,int page){
        return personalCenterDao.getBookBorrowedByUserIdPaged(userid,(page-1)*5,5);
    }
    public List<BookBorrowed> getBackBooksByUserId(long userid ,int page){
        return personalCenterDao.getBookBackedByUserIdPaged(userid,(page-1)*5,5);
    }
    public int getBorrowBooksPageNum(long userid){
        float size=personalCenterDao.getBookBorrowedByUserId(userid).size();
        float fpagenum=size/5;
        return (int)Math.ceil(fpagenum);
    }
    public int getBackBooksPageNum(long userid){
        return personalCenterDao.getBookBackedByUserId(userid).size()/5+1;
    }
}
