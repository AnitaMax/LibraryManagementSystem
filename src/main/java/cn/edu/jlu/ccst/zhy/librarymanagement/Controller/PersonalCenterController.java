package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.Service.PersonalCenterService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PersonalCenterController {
    @Autowired
    PersonalCenterService personalCenterService;

    @RequestMapping("/personal/personalcenter")
    public String  personalCenter(Model model, HttpSession session, HttpServletRequest request){
        UserUtil.setStateAndUser(model, session);
        User user= (User) session.getAttribute("user");
        //获得参数
        int page;
        try{
            page=Integer.parseInt(request.getParameter("page"));
        }catch (Exception e){page=1;}
        //获取搜索结果
        int pagenum=personalCenterService.getBorrowBooksPageNum(user.getUserid());
        model.addAttribute("pageNum",pagenum);
        List<BookBorrowed> bookBorroweds ;
        if(pagenum==1){
            model.addAttribute("page",1);
            bookBorroweds=personalCenterService.getBorrowBooksByUserId(user.getUserid());
        }else{
            if(page>pagenum&&page<1) {
                page=1;
            }
            bookBorroweds=personalCenterService.getBorrowBooksByUserId(user.getUserid(),page);
            model.addAttribute("page",page);
        }
        model.addAttribute("books",bookBorroweds);
        return "personal/personalcenter";

    }
}
