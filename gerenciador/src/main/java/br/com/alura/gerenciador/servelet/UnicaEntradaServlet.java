package br.com.alura.gerenciador.servelet;

import br.com.alura.gerenciador.actions.*;
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
                ListaEmpresas listaEmpresas = new ListaEmpresas();
                listaEmpresas.listaEmpresa(request, response);
                break;
            case "remove-empresa":
                RemoveEmpresa removeEmpresa = new RemoveEmpresa();
                removeEmpresa.removeEmpresa(request, response);
                break;
            case "mostra-empresa":
                MostraEmpresa mostraEmpresa = new MostraEmpresa();
                mostraEmpresa.mostraEmpresa(request, response);
                break;
            case "edita-empresa":
                EditaEmpresa editaEmpresa = new EditaEmpresa();
                editaEmpresa.editaEmpresa(request, response);
                break;
            case "nova-empresa":
                NovaEmpresa novaEmpresa = new NovaEmpresa();
                novaEmpresa.novaEmpresa(request, response);
                break;
        }
    }
}
