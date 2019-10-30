package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.Service.UserService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public  String login(User user, Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String result= request.getParameter("result");
        if(result!=null){
            switch (result){
                case "nologin":model.addAttribute("result","尚未登陆!");break;
            }
        }
        User loginedUser=(User) session.getAttribute("user");
        if(loginedUser!=null){
            model.addAttribute("result","您已登陆，正在跳转个人中心...");
            response.sendRedirect("/personal/personalcenter");
            return "login";
        }
        if(user.getUsername()!= null){
            loginedUser=userService.login(user);
            if(loginedUser!=null){
                session.setAttribute("user",user);
                return "redirect:/personal/personalcenter";
            }
            else {
                model.addAttribute("result","用户名或密码错误");
                return "login";
            }

        }
        return "login";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "success";
    }

}
