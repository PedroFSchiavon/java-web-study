package br.com.alura.gerenciador.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/novaempresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String novaEmpresa = req.getParameter("nome");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>A empresa " + novaEmpresa + " foi cadastrada com sucesso!</body></html>");
        System.out.println("Nova empresa cadastrada com sucesso");
    }
}
