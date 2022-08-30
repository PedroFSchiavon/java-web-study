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
<body>
    <c:if test="${not empty empresa}">
        A empresa ${empresa} foi criada com sucesso!
    </c:if>
    Lista de empresas: <br />
    <c:forEach items="${empresas}" var="empresa">
        <c:url value="/removeempresa?id=${empresa.id}" var="pathRemoveEmpresa" />
        <c:url value="/editaempresa?id=${empresa.id}" var="pathEditaEmpresa" />
        <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataCriacao}" pattern="dd/MM/yyyy"/>
            <a href="${pathRemoveEmpresa}"> remover</a> | <a href="${pathEditaEmpresa}" > editar</a> </li>
    </c:forEach>
</body>
<head>
    <title>Lista de empresas</title>
</head>
</html>