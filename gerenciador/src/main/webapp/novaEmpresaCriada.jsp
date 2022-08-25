<%--
  Created by IntelliJ IDEA.
  User: schiavon
  Date: 25/08/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%
    String novaEmpresa = (String) request.getAttribute("empresa");
    System.out.println(novaEmpresa);
%>
<html>
<head>
    <title>Nova Empresa Criada</title>
</head>
<body>
    A empresa <%=novaEmpresa%> foi criada com sucesso!
</body>
</html>
