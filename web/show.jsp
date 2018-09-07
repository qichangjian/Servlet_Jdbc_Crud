<%--
jsp中 application 、EL表达式中applicationScope 、 Java中servletContext 关系
http://blog.51cto.com/jianboli/1890443
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>统计网站访问量</title>
</head>
<body>
<h1 align="center">分IP统计访问次数</h1>
<table align="center" width="60%" border="1">
    <tr>
        <th>IP地址</th>
        <th>访 问 量</th>
    </tr>
    <!--循环遍历在ServletContext中的map，其中key是ip地址，value是访问次数 -->
    <c:forEach items="${applicationScope.map }" var="entry">
        <tr>
            <td>${entry.key }</td>
            <td>${entry.value }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
