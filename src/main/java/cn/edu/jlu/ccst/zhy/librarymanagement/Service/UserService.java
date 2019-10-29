package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.UserDao;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User login(User user){
        User loginedUser;
        loginedUser=userDao.UserLoginByUserName(user.getUsername(),user.getPassword());
        if(loginedUser==null){
            int id;
            try{
                id=Integer.parseInt(user.getUsername());
            }catch (NumberFormatException e){
                return  null;
            }

            loginedUser=userDao.UserLoginByUserId(id,user.getPassword());
        }
        return loginedUser;
    }
}
