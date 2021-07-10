package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author Daniel Liu 2020/1/30 19:45
 */
@WebServlet( "/user/*" )
public class UserServlet extends BaseServlet {

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        User u = userService.login(user);
        ResultInfo resultInfo = new ResultInfo();
        if (u == null) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误");
        }
        if (u != null && !"Y".equals(u.getStatus())) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户激活失败");
        }
        if (u != null && "Y".equals(u.getStatus())) {
            resultInfo.setFlag(true);
        }
        //查询出user存入session，用来查出用户名
        req.getSession().setAttribute("user", u);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(resultInfo);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(json);

    }

    public void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getSession().getAttribute("user");
        String json = new ObjectMapper().writeValueAsString(user);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(json);
    }

    public void checkCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //服务器通知浏览器不要缓存
        resp.setHeader("pragma", "no-cache");
        resp.setHeader("cache-control", "no-cache");
        resp.setHeader("expires", "0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0, 0, width, height);

        //产生4个随机验证码，12Ey
        String checkCode = getCheckCode();
        //将验证码放入HttpSession中
        req.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", resp.getOutputStream());
    }

    public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        // context:/travel
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }

    public void verify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        UserService userService = new UserServiceImpl();
        //激活
        boolean flag = userService.active(code);
        String msg;
        if (flag) {
            msg = "激活成功，请<a href='login.html'>登录<a/>";
        } else {
            msg = "激活失败";
        }
        resp.getWriter().write(msg);
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

}
