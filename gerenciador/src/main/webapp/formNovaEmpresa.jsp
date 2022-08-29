<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaempresa" var="pathNovaEmpresa"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
    <form action="${pathNovaEmpresa}" method="post">
        Nome: <input type="text" name="nome" />
        Data Criação: <input type="text" name="data">
        <input type="submit" />
    </form>
</body>
</html>