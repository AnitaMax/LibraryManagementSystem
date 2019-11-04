package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;

import cn.edu.jlu.ccst.zhy.librarymanagement.Service.BookManageService;
import cn.edu.jlu.ccst.zhy.librarymanagement.Service.BooksService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BookManageController {
    @Autowired
    BookManageService bookManageService;
    @RequestMapping("/personal/manager/bookmanage")
    public String bookManage(Model model, HttpSession session, HttpServletRequest request){
        UserUtil.setStateAndUser(model,session);

        return "/personal/manager/bookmanage";
    }
    @RequestMapping("/personal/manager/bookmanage/addbook")
    public String addBook(Book book, Model model, HttpSession session, HttpServletRequest request){
        boolean isSuccess=bookManageService.addBook(book);
        if(isSuccess){
            model.addAttribute("process_result","增加书籍成功！");
        }else{
            model.addAttribute("process_result","入库失败，请重试！");
        }

        return bookManage(model,session,request);
    }
}
