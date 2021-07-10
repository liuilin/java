package cn.itcast.web.filter;

import cn.itcast.web.servlet.CheckCodeServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/23 - 11:19
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取请求链接
        String uri = request.getRequestURI();
        //2.判断是否是登录资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/checkCodeServlet") || uri.contains("css/") || uri.contains("fonts/") || uri.contains("js/")) {
            //包含 放行
            chain.doFilter(req, resp);
        } else {
            //不包含 需要验证用户是否登录
            //3.
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //登录成功 放行
                chain.doFilter(req, resp);
            } else {
                //提示信息
                request.setAttribute("login_msg","您尚未登录，请登录");
                //登录失败
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }

        }


    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
