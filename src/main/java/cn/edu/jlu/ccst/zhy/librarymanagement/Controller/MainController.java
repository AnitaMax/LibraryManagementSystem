package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("state","login");
        }else{
            model.addAttribute("state","nologin");
        }
        return "index";
    }
}
