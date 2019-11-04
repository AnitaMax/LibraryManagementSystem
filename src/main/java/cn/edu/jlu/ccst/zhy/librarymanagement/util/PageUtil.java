package cn.edu.jlu.ccst.zhy.librarymanagement.util;

import cn.edu.jlu.ccst.zhy.librarymanagement.bean.BookBorrowed;
import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public class PageUtil {
    public static int num_in_page=5;
    public static int getPageNum(float size){
        float fpagenum=size/num_in_page;
        return (int)Math.ceil(fpagenum);
    }
    public static int getPagePara(String pageS,int pagenum){
        //获得参数
        int page;
        try{
            page=Integer.parseInt(pageS);
        }catch (Exception e){page=1;}
        if(page>pagenum&&page<1) {
            page=1;
        }
        return page;
    }

}
