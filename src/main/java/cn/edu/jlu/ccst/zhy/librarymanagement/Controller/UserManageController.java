package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.Service.UserManageService;
import cn.edu.jlu.ccst.zhy.librarymanagement.Service.UserService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserManageController {
    @Autowired
    UserManageService userManageService;

    @RequestMapping("/personal/manager/usermanage")
    public String userManage(Model model, HttpServletRequest request, HttpSession session){
        UserUtil.setStateAndUser(model,session);


        return "personal/manager/usermanage";
    }
    @RequestMapping("/personal/manager/usermanage/adduser")
    public String addManage(Model model, HttpServletRequest request, HttpSession session, User user){
        UserUtil.setStateAndUser(model,session);
        if(userManageService.addUser(user)){
            model.addAttribute("process_result","添加用户成功");
        }else{
            model.addAttribute("process_result","添加用户失败，请重试");
        }


        return userManage(model,request,session);
    }
    @RequestMapping("/personal/manager/usermanage/search")
    public String searchUserByid(long userid ,Model model, HttpServletRequest request, HttpSession session){
        User user=userManageService.searchUserBuUserid(userid);
        model.addAttribute("modify_user",user);
        if(user==null){
            model.addAttribute("process_result","没有此用户！");
        }
        return userManage(model,request,session);
    }

    @RequestMapping("/personal/manager/usermanage/modifyuser")
    public String modifyUser(Model model, HttpServletRequest request, HttpSession session, User user){
        UserUtil.setStateAndUser(model,session);
        if(userManageService.modifyUser(user)){
            model.addAttribute("process_result","修改用户成功");
        }else{
            model.addAttribute("process_result","修改用户失败，请重试");
        }


        return userManage(model,request,session);
    }

}
