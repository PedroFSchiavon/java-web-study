<%--
  Created by IntelliJ IDEA.
  User: schiavon
  Date: 25/08/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nova Empresa Criada</title>
</head>
<body>
    <c:if test="${not empty empresa}">
    A empresa ${empresa} foi criada com sucesso!
    </c:if>
    <c:if test="${empty empresa}">
        Nada foi cadastrado, o campo não pode ser vazio!
    </c:if>
</body>
</html>
