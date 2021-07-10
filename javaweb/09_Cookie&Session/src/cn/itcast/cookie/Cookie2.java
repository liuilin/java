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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

/**
 * ${DESCRIPTION}
 *
 * @author Daniel Liu 2020/1/8 8:26
 */
@WebServlet( "/cookie2" )
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        String cookieName = "lastTime";

        if (cookies == null || cookies.length == 0) {
            String time = getFormatTime();
            Cookie cookie = new Cookie(cookieName, URLEncoder.encode(time, "utf-8"));
            resp.addCookie(cookie);
            cookie.setMaxAge(60 * 60 * 60 * 12);
            resp.getWriter().write("<h1>您好，欢迎您首次访问<h1>");
        } else {
            IntStream.range(0, cookies.length).forEach(i -> {
                if (cookieName.equals(cookies[i].getName())) {
                    try {
                        String value = cookies[i].getValue();
                        resp.getWriter().write("<h1>欢迎回来，上次访问时间为：<h1>" + URLDecoder.decode(value, "utf-8"));
                        String formatTime = this.getFormatTime();
                        Cookie cookie = new Cookie(cookieName, URLEncoder.encode(formatTime, "utf-8"));
                        cookie.setMaxAge(60 * 60 * 60 * 12);
                        resp.addCookie(cookie);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private String getFormatTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        return formatter.format(LocalDateTime.now());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
