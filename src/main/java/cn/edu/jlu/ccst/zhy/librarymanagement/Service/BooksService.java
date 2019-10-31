package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.BooksDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
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
            booksDao.addBorrowLog(userid,bookid,new Date());
            return "借阅成功！";
        }else{
            return "数目不足，借阅失败，请稍后重试！";
        }
    }
}
