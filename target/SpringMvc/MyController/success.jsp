<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/11/4
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>success!</h1>
 ${requestScope.get("time")}
    ${requestScope.get("names")}


    <%--requestScope:${requestScope.get("user")} <br/>--%>
    <%--SessionScope:${sessionScope.get("user")} <br/>--%>

    requestScope:${requestScope.get("session")} <br/>
    SessionScope:${sessionScope.get("session")} <br/>


</body>
</html>
