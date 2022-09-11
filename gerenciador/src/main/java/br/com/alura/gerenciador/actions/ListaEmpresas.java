package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("listando empresas");
        Banco banco = new Banco();
        List<Empresa> lista = banco.getLista();

        request.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }
}
