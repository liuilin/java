<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<%--* 需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中--%>

<%

    List list = new ArrayList();
    list.add(new User("Jin", 20, new Date()));
    list.add(new User("Mugen", 21, new Date()));
    list.add(new User("Fuu", 18, new Date()));

    request.setAttribute("list", list);
%>

<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="s">
        <%--偶数--%>
        <c:if test="${s.count % 2 == 0}">

            <tr bgcolor="#db7093">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
        <%--奇数--%>
        <c:if test="${s.count % 2 != 0}">

            <tr bgcolor="#87ceeb">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
    </c:forEach>


</table>
</body>
</html>
