package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;
import cn.edu.jlu.ccst.zhy.librarymanagement.Service.BooksService;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.Book;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import cn.edu.jlu.ccst.zhy.librarymanagement.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BooksController {
    @Autowired
    BooksService booksService;

    @RequestMapping("/search")
    public String index(Model model, HttpSession session, HttpServletRequest request){
        UserUtil.setStateAndUser(model,session);
        //获得参数
        int page;
        try{
            page=Integer.parseInt(request.getParameter("page"));
        }catch (Exception e){page=1;}
        String content=request.getParameter("content");
        //获取搜索结果
        int pagenum=booksService.getPageNum(content);
        model.addAttribute("pageNum",pagenum);
        List<Book> books ;
        if(pagenum==1){
            model.addAttribute("page",1);
            books=booksService.searchBooks(content);
        }else{
            if(page>pagenum&&page<1) {
                page=1;
            }
            books=booksService.searchBooks(content,page);
            model.addAttribute("page",page);
        }
        model.addAttribute("books",books);
        return "books_search_result";
    }

    @RequestMapping("/borrow")
    @ResponseBody
    public String borrow(HttpServletRequest request,HttpSession session){
        //获取书的id
        String bookidString = request.getParameter("bookid");
        long bookid;
        try{
            bookid=Integer.parseInt(bookidString);
        }catch (Exception e){
            return "系统错误，请刷新重试";
        }
        //获取读者id
        User user = (User) session.getAttribute("user");
        if(user==null)
            return "您尚未登陆，请先登录！";
        //转发给service
        String result=booksService.borrow(user.getUserid(),bookid);
        return result;
    }
    @RequestMapping("/back")
    @ResponseBody
    public String back(HttpServletRequest request,HttpSession session){
        //获取书的id
        String bookidString = request.getParameter("bookid");
        long bookid;
        try{
            bookid=Integer.parseInt(bookidString);
        }catch (Exception e){
            return "系统错误，请刷新重试";
        }
        //获取读者id
        User user = (User) session.getAttribute("user");
        if(user==null)
            return "您尚未登陆，请先登录！";
        //转发给service
        String result=booksService.back(user.getUserid(),bookid);
        return result;
    }

}
