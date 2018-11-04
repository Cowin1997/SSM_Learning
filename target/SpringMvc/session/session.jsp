<%@ page import="org.apache.catalina.Session" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/17
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    name: ${sessionScope.get("name")}
</body>
</html>
