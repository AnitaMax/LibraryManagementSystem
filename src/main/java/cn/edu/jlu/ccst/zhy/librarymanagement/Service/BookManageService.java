package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.BookManageDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.BooksDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManageService {
    @Autowired
    BooksDao booksDao;
    @Autowired
    BookManageDao bookManageDao;

    public boolean addBook(Book book){
        List<Book> books = booksDao.searchBooksByIsbn(book.getIsbn());
        if(books.size()>0){
            booksDao.updateBookNumById(books.get(0).getBookid(),book.getNum());
            return true;
        }else{
            int i = bookManageDao.addBook(book.getName(), book.getIsbn(), book.getDescribe(), book.getAuthor(), book.getPublisher(), book.getLocation(), book.getNum());
            if(i==1){
                return true;
            }else{
                System.out.println("入库时出现未知错误");
            }
        }
        return false;
    }
}
