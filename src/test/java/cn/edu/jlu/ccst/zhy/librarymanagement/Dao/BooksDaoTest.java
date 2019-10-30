package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class BooksDaoTest {
    @Autowired
    BooksDao booksDao;
    @Test
    void searchBooksByName() {
        System.out.println(booksDao.searchBooksByName("计算机"));
    }

    @Test
    void searchBooksByIsbn() {
        System.out.println(booksDao.searchBooksByIsbn("9787040503821"));
    }

    @Test
    void searchBooksByAuthor() {
        System.out.println(booksDao.searchBooksByAuthor("胡亮"));
    }

    @Test
    void searchBooks() {
        System.out.println(booksDao.searchBooks("胡亮"));
    }
}