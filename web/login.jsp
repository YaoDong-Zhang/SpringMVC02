<%--
  Created by IntelliJ IDEA.
  User: 44667
  Date: 2018/9/11
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body style="font-size: 20px;">
    <h5>读取请求参数的第一种方式：使用request.getParameter()方法</h5>
    <h5>读取请求参数的第二种方式：使用@RequestParam注解</h5>
    <h5>读取请求参数的第三种方式：将请求封装成一个javabean</h5>
    <h5>向页面传值的第一种方式：使用request</h5>
    <h5>向页面传值的第二种方式：使用ModelAndView</h5>
    <h5>向页面传值的第三种方式：使用ModelMap</h5>
    <h5>向页面传值的第四种方式：使用session</h5>
    <form name="form" method="post" action="login6.do">
      账号:<input type="text" name="adminCode"><br>
      密码:<input type="password" name="password"/><br>
      <input type="submit" value="登录">
    </form>
  </body>
</html>
