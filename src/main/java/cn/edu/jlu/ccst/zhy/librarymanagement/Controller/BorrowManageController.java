package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.Service.BorrowManageService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.PageUtil;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BorrowManageController {
    @Autowired
    BorrowManageService borrowManageService;

    @RequestMapping("/personal/manager/borrowmanage")
    public String borrowManage(Model model, HttpServletRequest request, HttpSession session){
        UserUtil.setStateAndUser(model, session);
        //超期记录
        //最大页码
        int pagenum=borrowManageService.getOverTimeLogPageNum();
        model.addAttribute("pageNum",pagenum);
        //当前页码
        int page= PageUtil.getPagePara(request.getParameter("page"),pagenum);
        model.addAttribute("page",page);
        //获取结果
        List<BookBorrowed> bookBorroweds ;
        bookBorroweds=borrowManageService.getOverTimeLog(page);
        model.addAttribute("books",bookBorroweds);

        //借阅记录
        //最大页码
        int pagenum2=borrowManageService.getBorrowPageNum();
        model.addAttribute("pageNum2",pagenum2);
        //当前页码
        int page2= PageUtil.getPagePara(request.getParameter("page2"),pagenum2);
        model.addAttribute("page2",page2);
        //获取结果
        List<BookBorrowed> booklogs ;
        booklogs=borrowManageService.getBorrowLog(page2);
        model.addAttribute("booklogs",booklogs);

        return "/personal/manager/borrowmanage";
    }
}
