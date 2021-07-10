package cn.itcast.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/14 - 15:42
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");

        System.out.println("demo1....");
        /*//2.设置状态码
        resp.setStatus(302);
        //3.设置
        resp.setHeader("location","/test15/responseDemo2");*/

        //动态获取虚拟目录
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
