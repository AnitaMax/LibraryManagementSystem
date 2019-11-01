package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonalCenterDaoTest {
    @Autowired
    PersonalCenterDao personalCenterDao;
    @Test
    void getBorrowBooksByUserId() {
       // System.out.println(personalCenterDao.getBorrowBooksByUserId(10000));
    }

    @Test
    void getBookBorrowedByUserId() {
        //System.out.println(personalCenterDao.getBookBorrowedByUserIdPaged(10000));
    }
}