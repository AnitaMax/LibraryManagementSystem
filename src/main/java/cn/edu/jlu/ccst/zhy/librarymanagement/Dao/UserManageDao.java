package cn.edu.jlu.ccst.zhy.librarymanagement.Dao;

import org.apache.ibatis.annotations.Insert;

import java.util.Date;

public interface UserManageDao {
    @Insert("insert into users(userid,username,password,type,register_time) values(#{userid},#{username},#{password},#{type},#{register_time})")
    int addUser(long userid, String username, String password, String type, Date register_time);
}
