package br.com.alura.gerenciador.servelet;

import br.com.alura.gerenciador.actions.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramAction = request.getParameter("action");
        String nome = null;

        switch (paramAction) {
            case "lista-empresas":
                ListaEmpresas listaEmpresas = new ListaEmpresas();
                nome = listaEmpresas.listaEmpresa(request, response);
                break;
            case "remove-empresa":
                RemoveEmpresa removeEmpresa = new RemoveEmpresa();
                nome = removeEmpresa.removeEmpresa(request, response);
                break;
            case "mostra-empresa":
                MostraEmpresa mostraEmpresa = new MostraEmpresa();
                nome = mostraEmpresa.mostraEmpresa(request, response);
                break;
            case "edita-empresa":
                EditaEmpresa editaEmpresa = new EditaEmpresa();
                nome = editaEmpresa.editaEmpresa(request, response);
                break;
            case "nova-empresa":
                NovaEmpresa novaEmpresa = new NovaEmpresa();
                nome = novaEmpresa.novaEmpresa(request, response);
                break;
            case "nova-empresa-form":
                NovaEmpresaForm novaEmpresaform = new NovaEmpresaForm();
                nome = novaEmpresaform.criaEmpresa(request, response);
                break;
        }

        String[] entradaENome = nome.split(":");

        if(Objects.equals(entradaENome[0], "forward")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + entradaENome[1]);
            rd.forward(request, response);
        }else {
            response.sendRedirect(entradaENome[1]);
        }
    }
}
