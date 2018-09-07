<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/6
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" href="css/main.css"/>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center>

欢迎：${loginUName}登录&nbsp;| &nbsp; <a href="loginout.jsp">注销</a>
    <h3>用户信息页面</h3>
    <table>
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${uLists}" var="list">
            <tr>
                <td>${list.uid}</td>
                <td>${list.uname}</td>
                <td>${list.password}</td>
                <td><a href="/user?method=toUpdate&uid=${list.uid}&uname=${list.uname}&password=${list.password}">修改</a></td>
                <td><a href="/user?method=delete&uid=${list.uid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    ${deleteMsg}
    <a href="show.jsp">show IPCount</a>
</center>
</body>
</html>
