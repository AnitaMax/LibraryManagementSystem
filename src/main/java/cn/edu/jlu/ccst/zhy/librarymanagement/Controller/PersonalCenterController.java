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

    @RequestMapping("/personalcenter")
    public ModelAndView personalCenter( HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        User loginedUser= (User) session.getAttribute("user");
        if (loginedUser!=null){
            modelAndView.setViewName("personalcenter");
            modelAndView.addObject("user",loginedUser);
            return modelAndView;
        }else {
            //modelAndView.addObject("result","您需要先登录"); 会变成
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

    }
}
