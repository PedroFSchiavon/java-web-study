<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: schiavon
  Date: 30/08/2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<c:url value="entrada?action=edita-empresa&id=${id}" var="pathEditaEmpresa" />
<fmt:formatDate value="${empresaData}" pattern="dd/MM/yyyy" var="dataFormatada" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edita Empresa</title>
</head>
<body>
    <form action="${pathEditaEmpresa}" method="post">
      Nome: <input type="text" value="${empresaNome}" name="nome" />
      Data Criação: <input type="text" value="${dataFormatada}" name="data">

      <input type="submit" value="Enviar"/>
    </form>
</body>
</html>
