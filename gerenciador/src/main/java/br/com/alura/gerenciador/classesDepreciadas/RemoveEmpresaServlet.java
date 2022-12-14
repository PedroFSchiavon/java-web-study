package br.com.alura.gerenciador.classesDepreciadas;

import br.com.alura.gerenciador.model.Banco;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(urlPatterns = "/removeempresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParaRemover = request.getParameter("id");
        System.out.println("Cheguei aqui, olha meu id = " + idParaRemover);

        Banco banco = new Banco();
        banco.removeEmpresa(Integer.valueOf(idParaRemover));

        response.sendRedirect("listaempresa");
    }

}
