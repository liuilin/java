package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 案例：记录上次访问时间
 * <p>
 * 1. 需求：
 * 1. 访问第一个servlet，如果是第一次访问，则提示：您好，欢迎首次访问。
 * 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问的时间为：显示时间字符串
 * 2. 分析：
 * 1. 可以采用cookie来完成
 * 2. 在服务器中的servlet判断是否有一个lastTime的cookie
 * 1. 有：不是第一次访问
 * 1. 响应数据：欢迎回来，您上次访问的时间为：xxxx
 * 2. 写回cookie：lastTime=xxxx
 * 2. 没有：是第一次访问
 * 1. 响应数据：您好，欢迎首次访问。
 * 2. 写回cookie：lastTime=xxxx
 *
 * @author Gakki
 * @date 2018/11/17 - 11:30
 */
@WebServlet("/cookieTest1")
public class CookieTest1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.获取所有Cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        //2.遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                //3.获取cookie名称
                String name = c.getName();
                if ("lastTime".equals(name)) {

                    flag = true;
                    
                    String value = c.getValue();
                    value = URLDecoder.decode(value, "utf-8");
//                    resp.getWriter().write("<h1>欢迎回来，您上次访问的时间为：" + value + "</h1>");

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String strDate = sdf.format(date);
                    strDate = URLEncoder.encode(strDate, "utf-8");
                    c.setValue(strDate);

                    c.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(c);



                    break;
                }
            }
        }
        
        
        
        if (cookies == null || cookies.length == 0 || flag == false) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(date);
            strDate = URLEncoder.encode(strDate, "utf-8");
            Cookie c = new Cookie("lastTime", strDate);

            c.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(c);

            resp.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
