<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "user/testAjax",
                    type: "post",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"haha","password":"321","age":30}',
                    dataType: "json",
                    success: function (data) {
                        alert(data);
                        alert(data.username);
                    }
                });
            });
        })
    </script>
</head>
<body>
<a href="user/testString">testString</a>

<br/>

<a href="user/testVoid">testVoid</a>

<br/>

<a href="user/testModelAndView">testModelAndView</a>

<br/>

<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

<br/>

<button id="btn">发送ajax的请求</button>

</body>
</html>
