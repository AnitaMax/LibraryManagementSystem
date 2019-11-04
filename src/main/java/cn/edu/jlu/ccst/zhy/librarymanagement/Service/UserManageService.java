package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.UserManageDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserManageService {
    @Autowired
    UserManageDao userManageDao;

    public boolean addUser(User user){
        int num=userManageDao.addUser(user.getUserid(),user.getUsername(),user.getPassword(),user.getType(),new Date());
        if(num==1){
            return true;
        }
        return false;
    }
}
