package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface BooksDao {
    @Select("select * from books where name like CONCAT('%',#{name},'%') ")
    List<Book> searchBooksByName(String name);
    @Select("select * from books where author like CONCAT('%',#{author},'%') ")
    List<Book> searchBooksByAuthor(String author);
    @Select("select * from books where author like CONCAT('%',#{content},'%') or name like CONCAT('%',#{content},'%')  or isbn=#{content}")
    List<Book> searchBooks(String content);
    @Select("select * from books where isbn=#{isbn}")
    List<Book> searchBooksByIsbn(String isbn);
}
