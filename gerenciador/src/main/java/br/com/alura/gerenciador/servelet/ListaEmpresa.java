package br.com.alura.gerenciador.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/listaempresa")
public class ListaEmpresa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> lista = new ArrayList<>(banco.getLista());

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<ul>");
        lista.forEach(empresa -> out.println("<li>" + empresa.getNome() + "</li>"));
        out.println("</ul>");
        out.println("</html></body>");
    }

}
