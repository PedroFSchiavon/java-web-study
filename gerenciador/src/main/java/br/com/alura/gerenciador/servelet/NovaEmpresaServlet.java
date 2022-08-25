package br.com.alura.gerenciador.servelet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/novaempresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String novaEmpresa = request.getParameter("nome");
        PrintWriter out = response.getWriter();

        Empresa empresa = new Empresa();
        empresa.setNome(novaEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);
        System.out.println("Empresa cadastrada com sucesso!" + empresa.getNome());

        //repassando para o JSP
        RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);
    }
}
