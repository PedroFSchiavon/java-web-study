<%@ page import="java.util.List" %>
<%@ page import="br.com.alura.gerenciador.servelet.Empresa" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: schiavon
  Date: 25/08/2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Empresa> listaEmpresa = (List<Empresa>) request.getAttribute("listaEmpresas");
    PrintWriter pw = response.getWriter();
%>
<html>
<head>
    <title>Lista de empresas</title>
</head>
<body>
    <ul>
        <%listaEmpresa.forEach(empresa -> pw.println("<li>" + empresa.getNome() + "</li>"));%>
    </ul>
</body>
</html>
