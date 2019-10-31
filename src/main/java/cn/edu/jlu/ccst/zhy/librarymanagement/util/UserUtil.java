package cn.edu.jlu.ccst.zhy.librarymanagement.util;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class UserUtil {
     public static void setStateAndUser(Model model, HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("state","login");
            User loginedUser= (User) session.getAttribute("user");
            model.addAttribute("user",loginedUser);
        }else{
            model.addAttribute("state","nologin");
        }
    }
}
