<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach begin="100" end="300" step="5" var="i" varStatus="s">
    <c:if test="${i % 3 == 0}">
        <font color="#db7093">${i}</font>
    </c:if>
    <c:if test="${i % 3 != 0}">
        <font color="#ffe4c4">${i}</font>
    </c:if>
</c:forEach>

</body>
</html>