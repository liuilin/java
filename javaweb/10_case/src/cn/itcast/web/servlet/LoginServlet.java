package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Gakki
 * @date 2018/11/20 - 11:03
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取数据
        //2.1获取用户填写的验证码
        String verifycode = req.getParameter("verifycode");
        //2.2验证码校验
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //如果验证码不正确
            //提示信息
            req.setAttribute("login_msg", "验证码错误");
            //转发登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            //不执行if之后的代码
            return;
        }
        Map<String, String[]> map = req.getParameterMap();
        //3.封装成user对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Service查询
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        //5.判断是否登录成功
        if (loginUser != null) {
            //登录成功
            //将数据存入session中
            session.setAttribute("user", loginUser);
            //跳转页面
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            //登录失败
            //提示信息
            req.setAttribute("login_msg", "用户名或密码错误");
            //跳转页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
