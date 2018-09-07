package com.qcj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 编码过滤
 */
@WebFilter(filterName = "CharsetFilter",urlPatterns = "/*")
public class CharsetFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    //处理接受请求和响应 过滤器链
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //1.得到application
        chain.doFilter(req, resp);//放行

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
