<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/11/4
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>
</head>
<body>

    <p>----------------测试testModelAttribute----------------------</p>
    <form action="MyController/testModelAttribute" method="post">
        <input type="hidden" name="userName" value="admin">
        修改地址:<input type="text" name="userInfo.address"><br/>
        修改性别:<input type="text" name="userInfo.sex"><br/>
        <input type="submit" value="提交">
    </form>


    <p>----------------测试testSessionAttributes----------------------</p>
    <a href="MyController/testSessionAttributes">测试testSessionAttributes</a>

    <p>----------------测试testMap----------------------</p>
    <a href="MyController/testMap">测试testMap</a>

    <p>----------------测试testModelAndView----------------------</p>
    <a href="MyController/testModelAndView">测试testModelAndView</a>

    <p>----------------原生ServletApi----------------------</p>
    <a href="MyController/testServletApi">原生ServletApi</a>

    <p>----------------测试pojo封装----------------------</p>
    <form action="MyController/testPojo" method="post" accept-charset="utf-8">
        用户名:<input type="text" name="userName"><br/>
        密码:<input type="password" name="passWord"><br/>
        地址:<input type="text" name="userInfo.address"><br/>
        性别:<input type="text" name="userInfo.sex"><br/>
        <input type="submit" value="提交">
    </form>
    <p>-------------------------------------------------</p>
    <a href="MyController/testCookieValue">测试@CookieValue</a>
    <br/>
    <a href="MyController/test">Test PathVariable</a>
    <br/>
    <a href="MyController/TestRequestParam?username=abc&password=admin">Test RequestParam</a>
</body>
</html>
