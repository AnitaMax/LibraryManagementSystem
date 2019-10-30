package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.Service.PersonalCenterService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalCenterController {
    @Autowired
    PersonalCenterService personalCenterService;

    @RequestMapping("/personal/personalcenter")
    public String  personalCenter(Model model, HttpSession session){
        User user= (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "personal/personalcenter";

    }
}
