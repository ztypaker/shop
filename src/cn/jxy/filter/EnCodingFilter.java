package cn.jxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "EnCodingFilter",urlPatterns = { "/*" })
public class EnCodingFilter implements Filter {
    public void destroy() {
        System.out.println("销毁过滤器");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("过滤器工作");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
