<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.获取所有Cookie
    Cookie[] cookies = request.getCookies();
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
%>

<h1>欢迎回来，您上次访问的时间为：<%=value%>
</h1>
<input type="text">
<input type="password">

<%
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String strDate = sdf.format(date);
                strDate = URLEncoder.encode(strDate, "utf-8");
                c.setValue(strDate);

                c.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(c);
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
        response.addCookie(c);
%>

<h1>您好，欢迎您首次访问</h1>
<input type="text">

<%
    }
%>
</body>
</html>
