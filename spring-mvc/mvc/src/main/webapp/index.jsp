<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="hi">click</a>
<form action="user/account" method="post">
    姓名：<input type="text" name="name">
    金钱：<input type="text" name="money">
    <%--    用户名：<input type="text" name="user.username">--%>
    <%--    年龄：<input type="text" name="user.age">--%>
    时间：<input type="text" name="date">
    <input type="submit" value="提交">
</form>
</body>
</html>
