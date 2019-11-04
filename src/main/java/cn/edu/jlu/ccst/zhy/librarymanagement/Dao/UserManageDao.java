package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface UserManageDao {
    @Insert("insert into users(userid,username,password,type,register_time) values(#{userid},#{username},#{password},#{type},#{register_time})")
    int addUser(long userid, String username, String password, String type, Date register_time);

    @Select("select * from users where userid=#{userid} ")
    User searchUserByUserid(long userid);

    @Insert("update users set userid=#{userid},username=#{username},password=#{password},type=#{type} where userid=#{userid}")
    int modifyUser(long userid, String username, String password, String type);
}
