package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListaEmpresas {
    public String listaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("listando empresas");
        Banco banco = new Banco();
        List<Empresa> lista = banco.getLista();

        request.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }
}
