<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/6
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<center>
    <h3>修改页面</h3>
    <form action="/user" method="post">
        <input type="hidden" value="update" name="method"/>
        uid:<input type="text" name="uid" readonly value="${uid}"/><br/>
        userName:<input type="text" name="uname" value="${uname}"/><br/>
        password:<input type="password" name="password" value="${password}"/><br/>
        <input type="submit" value="修改"/>
        <a href="/user?method=login&uname=${loginUName}&password=${loginPassword}">返回</a><br/>
        <span id="updateMsg">${updateMsg}</span>
    </form>
</center>
</body>
</html>
