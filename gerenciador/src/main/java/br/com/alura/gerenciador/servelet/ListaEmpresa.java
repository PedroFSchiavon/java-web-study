package br.com.alura.gerenciador.servelet;

import jakarta.servlet.RequestDispatcher;
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

        //Enviando para o JSP
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
        request.setAttribute("listaEmpresas", lista);
        rd.forward(request, response);
    }

}
