<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
Created by IntelliJ IDEA.
  User: schiavon
  Date: 25/08/2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de empresas</title>
</head>
<body>
    Lista de empresas: <br />
    <c:forEach items="${empresas}" var="empresa">
        <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataCriacao}" pattern="dd/MM/yyyy"/></li>
    </c:forEach>
</body>
</html>
