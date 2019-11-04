package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.BooksDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksDao booksDao;

    public List<Book> searchBooks(String content){
        return booksDao.searchBooks(content);
    }
    public int getPageNum(String content){
        float size=booksDao.searchBooks(content).size();
        return PageUtil.getPageNum(size);
    }
    public  List<Book> searchBooks(String content,int page){
        return booksDao.searchBooksByPage(content,(page-1)*PageUtil.num_in_page,PageUtil.num_in_page);
    }

    public List<Book> searchBooksByAuthor(String author){
        return booksDao.searchBooksByAuthor(author);
    }

    public List<Book> searchBooksByName(String name){
        return booksDao.searchBooksByName(name);
    }

    public List<Book> searchBooksByIsbn(String isbn){
        return booksDao.searchBooksByIsbn(isbn);
    }

    public String borrow(long userid,long bookid){
        Book book=booksDao.searchBooksByBookId(bookid);
        if(book.getNum()>0){
            booksDao.updateBookNumById(bookid,-1);
            booksDao.addBorrowLog(userid,bookid,new Date());
            return "借阅成功！";
        }else{
            return "数目不足，借阅失败，请稍后重试！";
        }
    }
    public String back(long userid,long bookid){
        List<String> state=booksDao.getStateByUseridAndBookid(userid,bookid);
        for (String s:state) {
            if(s.equals("borrow")){
                booksDao.updateBookNumById(bookid,1);
                booksDao.updateBackLog(userid,bookid);
                booksDao.addBackLog(userid,bookid,new Date());
                return "归还成功！";
            }
        }
        return "归还失败！";

    }
}
