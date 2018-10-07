package cn.jxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("33333过滤器销毁");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("33333过滤器工作");
        //
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if(session.getAttribute("user")!=null){
            //合法用户
            chain.doFilter(request, response);
        }else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("3333过滤器初始化");
    }

}
