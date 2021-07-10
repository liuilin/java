package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
 * @date 2018/11/18 - 21:44
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.获取所有cookie
        Cookie[] cookies = req.getCookies();
        //没有cookie
        boolean flag = false;
        //2.遍历数组
        //cookies可能是对象，&&两边都是true才满足，采执行下面代码
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                if ("lastTime".equals(name)) {
                    //有cookie
                    flag = true;
                    //有cookie，不是第一次访问
                    //响应数据：欢迎回来，您上次访问的时间为：xxxx
                    String value = c.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    resp.getWriter().write("欢迎回来，您上次访问的时间为:" + value);


                    //写回cookie：lastTime=xxxx
                    String strTime = setTime();

                    c.setValue(strTime);
                    c.setMaxAge(60 * 60);
                    resp.addCookie(c);

                    break;//可以继续运行之后的代码，而return则直接返回不执行之后的代码
                }
            }
        }

        if (cookies == null || cookies.length == 0 || !flag) {
            //首次访问
            //响应数据：您好，欢迎首次访问。
            //写回cookie：lastTime = xxxx
            resp.getWriter().write("您好，欢迎首次访问");
            String strTime = setTime();
            Cookie c = new Cookie("lastTime", strTime);
            c.setMaxAge(60 * 60);
            resp.addCookie(c);
        }

    }

    private String setTime() throws UnsupportedEncodingException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String strTime = sdf.format(date);
        strTime = URLEncoder.encode(strTime, "utf-8");
        return strTime;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }
}
