package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * ${DESCRIPTION}
 *
 * @author Daniel Liu 2020/1/18 2:11
 */
@WebServlet( "/registerServlet" )
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String checkCode = (String) session.getAttribute("CHECKCODE_SERVER");
            session.removeAttribute("CHECKCODE_SERVER");

            ResultInfo resultInfo = new ResultInfo();
            Map<String, String[]> map = req.getParameterMap();
            String code = req.getParameter("check");
            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("application/json;charset=UTF-8");
            if (checkCode == null || !checkCode.equalsIgnoreCase(code)) {
                resultInfo.setErrorMsg("验证码错误，请重新输入");
                String json = objectMapper.writeValueAsString(resultInfo);
                resp.getWriter().write(json);
                return;
            }
            User user = new User();
            BeanUtils.populate(user, map);
            UserServiceImpl userService = new UserServiceImpl();
            boolean flag = userService.registered(user);
            if (flag) {
                resultInfo.setFlag(true);
            } else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("注册失败");
            }
            String json = objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().write(json);
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
