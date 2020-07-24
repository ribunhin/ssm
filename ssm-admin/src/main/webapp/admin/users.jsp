<%--
  Created by IntelliJ IDEA.
  User: webbleen
  Date: 7/23/2020
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>Users</title>
</head>
<body>
<c:forEach items="${list}" var="user">
    ${user.id}--${user.username}--${user.icon}
</c:forEach>
</body>
</html>
