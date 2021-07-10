package com.imugen.web;

import com.imugen.dao.LoginDao;
import com.imugen.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * ${DESCRIPTION}
 *
 * @author Daniel Liu 2020/1/16 9:00
 */
@WebServlet( "/loginServlet" )
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            String username = req.getParameter("name");
//            String password = req.getParameter("password");
//            User user = new User();
//            user.setName(name);
//            user.setPassword(password);
            User user = new User();
            BeanUtils.populate(user, req.getParameterMap());
            User loginUser = new LoginDao().login(user);
            if (loginUser == null) {
                req.getRequestDispatcher("/failedServlet").forward(req, resp);
            } else {
                req.getRequestDispatcher("/successServlet").forward(req, resp);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
