package cn.edu.jlu.ccst.zhy.librarymanagement.bean;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

class BookBorrowedTest {

    @Test
    void getLeftTime() {
        BookBorrowed bookBorrowed = new BookBorrowed();
        bookBorrowed.borrowtime=new Date();
        bookBorrowed.getLeftTime();
    }

    @Test
    void outOfTime() {
        BookBorrowed bookBorrowed = new BookBorrowed();
        bookBorrowed.borrowtime= DateUtils
                .addDays(new Date(), -16);
        System.out.println(bookBorrowed.isOutOfTime());
    }
}