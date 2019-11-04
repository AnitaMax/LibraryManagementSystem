package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.BorrowManageDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowManageService {
    @Autowired
    BorrowManageDao borrowManageDao;
    public List<BookBorrowed> getOverTimeLog(){
        return borrowManageDao.getOverTimeLog();
    }
    public List<BookBorrowed> getOverTimeLog(int page){
        return borrowManageDao.getOverTimeLogPaged((page-1)*PageUtil.num_in_page,PageUtil.num_in_page);
    }
    public int getOverTimeLogPageNum(){
        float size=borrowManageDao.getOverTimeLog().size();
        return PageUtil.getPageNum(size);
    }
    public List<BookBorrowed> getBorrowLog(){
        return borrowManageDao.getBorrowLog();
    }
    public List<BookBorrowed> getBorrowLog(int page){
        return borrowManageDao.getBorrowLogPaged((page-1)*PageUtil.num_in_page,PageUtil.num_in_page);
    }
    public int getBorrowPageNum(){
        float size=borrowManageDao.getBorrowLog().size();
        return PageUtil.getPageNum(size);
    }
}
