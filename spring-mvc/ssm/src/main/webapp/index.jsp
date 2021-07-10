<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">点我</a>
<form action="account/save" method="post">
    <input type="text" name="name"/>
    <input type="text" name="money"/>
    <input type="submit" value="保存">
</form>
</body>
</html>
