package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.PersonalCenterDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.PageUtil;
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
        return personalCenterDao.getBookBorrowedByUserIdPaged(userid,(page-1)*PageUtil.num_in_page,PageUtil.num_in_page);
    }
    public List<BookBorrowed> getBackBooksByUserId(long userid ,int page){
        return personalCenterDao.getBookBackedByUserIdPaged(userid,(page-1)*PageUtil.num_in_page,PageUtil.num_in_page);
    }
    public int getBorrowBooksPageNum(long userid){
        float size=personalCenterDao.getBookBorrowedByUserId(userid).size();
        return PageUtil.getPageNum(size);
    }
    public int getBackBooksPageNum(long userid){
        return personalCenterDao.getBookBackedByUserId(userid).size()/5+1;
    }
}
