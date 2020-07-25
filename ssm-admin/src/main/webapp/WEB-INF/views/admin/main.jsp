<%--
  Created by IntelliJ IDEA.
  User: webbleen
  Date: 7/20/2020
  Time: 1:25 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.webbleen.ssm.shiro.AdminProfile" %>
<%@ page import="javax.security.auth.Subject" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%
    String path = request.getContextPath();
    String basePth = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePth%>">
    <title>My JSP 'index.jsp' starting page</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/logout">登出</a>

您好,<shiro:principal property="username" />

<shiro:hasPermission name="user:view">
    <h1>用户</h1>
</shiro:hasPermission>

<shiro:hasPermission name="role:view">
    <h1>角色</h1>
</shiro:hasPermission>

<shiro:hasPermission name="menu:view">
    <h1>菜单</h1>
</shiro:hasPermission>
<%--<jsp:forward page="admin/main.jsp"></jsp:forward>--%>
</body>
</html>
