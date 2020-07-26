<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>H+ 后台主题UI框架 - 登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
<%--            <h1 class="logo-name">H+</h1>--%>
            <img class="m-b" src="${pageContext.request.contextPath}/images/bootstrap-solid.svg" alt="" width="72" height="72">
        </div>
        <h3>欢迎使用 H+</h3>

        <form class="m-t" role="form" action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label for="inputUsername" class="sr-only">用户名</label>
                <input type="text" id="inputUsername" name="username" class="form-control" placeholder="用户名" value="${username}"
                       required　autofocus>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="sr-only">密码</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" value="${password}"
                       required>
            </div>
            <span class="msg" style="color:#6722228a;"
                  href="javascript:void(0);">${message}</span>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>

</body>
</html>