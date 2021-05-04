<%--
  Created by IntelliJ IDEA.
  User: hsiaopan
  Date: 2021/5/4
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Hello World - JSP</title>
</head>
<body>
<%--JSP Comment --%>
<h1>Hello World!</h1>
<p>
    <%
        out.println("Your IP address is ");
    %>
    <span style="color: red">
        <%= request.getRemoteAddr() %>
    </span>
</p>
<p>
    <%@ page import="java.time.LocalDateTime" %>
</p>
<p> The date and time is
    <span>
        <%
            out.println(LocalDateTime.now().toString());
        %>
    </span>
</p>
</body>
</html>
