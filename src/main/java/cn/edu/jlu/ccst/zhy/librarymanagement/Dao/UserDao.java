package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from users")
    List<User> getAll();
    @Select("select * from users where username=#{username} and password=#{password}")
    User UserLoginByUserName(String username,String password);
    @Select("select * from users where userid=#{userid} and password=#{password}")
    User UserLoginByUserId(long userid,String password);

}
