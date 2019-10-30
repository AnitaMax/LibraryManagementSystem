package cn.edu.jlu.ccst.zhy.librarymanagement.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BooksController {
    @RequestMapping("/search")
    public String index(Model model, HttpSession session){
        return null;
    }
}
