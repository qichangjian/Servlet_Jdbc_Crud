<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>login</title>
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
          <h3>登录页面</h3>
          <form action="/user" method="post">
              <input type="hidden" value="login" name="method"/>
              userName:<input type="text" name="uname"/><br/>
              password:<input type="password" name="password"/><br/>
              <input type="submit" value="登录"/>
              <a href="register.jsp">注册</a><br/>
              <span id="failMsg">${failMsg}</span>
          </form>
      </center>
  </body>
</html>
