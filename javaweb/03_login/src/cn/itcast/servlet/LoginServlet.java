package cn.itcast.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Gakki
 * @date 2018/11/15 - 10:49
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*//1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.封装为user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        //1.获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        //2.使用beanUtil封装user对象
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //3.调用userDao方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        //4.判断user是否为空
        if (user != null) {
            //存储用户信息到req域
            req.setAttribute("user",user);
            //登录成功
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        } else {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        }



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
