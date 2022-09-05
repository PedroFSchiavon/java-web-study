package br.com.alura.gerenciador.servelet;

import br.com.alura.gerenciador.actions.ListaEmpresas;
import br.com.alura.gerenciador.actions.RemoveEmpresa;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramAction = request.getParameter("action");

        switch (paramAction) {
            case "lista-empresas":
                System.out.println("listando empresas");
                ListaEmpresas listaEmpresas = new ListaEmpresas();
                listaEmpresas.listaEmpresa(request, response);
                break;
            case "remove-empresa":
                System.out.println("Removendo empresa");
                RemoveEmpresa removeEmpresa = new RemoveEmpresa();
                removeEmpresa.removeEmpresa(request, response);
                break;
            case "nova-empresa":
                System.out.println("Criando empresa");
                break;
        }
    }
}
