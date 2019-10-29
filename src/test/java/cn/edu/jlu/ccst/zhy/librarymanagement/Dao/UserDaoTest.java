package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {
    @Autowired
    private  UserDao userDao;
    @Test
    void getAll() {
        System.out.println(userDao.getAll());
    }
    @Test
    void userLoginByUserName() {
        System.out.println(userDao.UserLoginByUserName("admin","123456789"));
    }
    @Test
    void userLoginByUserId() {
        System.out.println(userDao.UserLoginByUserId(10000,"123456789"));
    }

}