package cn.edu.jlu.ccst.zhy.librarymanagement.Filter;


import cn.edu.jlu.ccst.zhy.librarymanagement.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/personal/bookmanage","/personal/bookmanage/*"}, filterName = "D_AdminFilter")
public class D_AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //放行静态资源
        StringBuffer url=request.getRequestURL();
        if(url.indexOf("layui")>=0||url.indexOf("jquery")>=0){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //判断是否有管理员权限
        User loginedUser= (User) request.getSession().getAttribute("user");
        System.out.println("拦截:"+request.getRequestURL());
        if (loginedUser.getType().equals("manager")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpServletResponse response=(HttpServletResponse) servletResponse;
            response.sendRedirect("/personal/personalcenter");
        }
    }

    @Override
    public void destroy() {

    }
}
