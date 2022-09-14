<%--
  Created by IntelliJ IDEA.
  User: schiavon
  Date: 9/11/22
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="pathEntrada" />
<html>
<head>
    <title>Formulário de Login</title>
</head>
<body>
    <c:import url="logoutELoginTemplate.jsp" />
    <form action="${pathEntrada}" method="post">
        Login: <input type="text" name="login" />
        Senha: <input type="password" name="password">
        <input type="hidden" value="AutenticaLogin" name="action">
        <input type="submit" value="Logar">
    </form>
</body>
</html>
