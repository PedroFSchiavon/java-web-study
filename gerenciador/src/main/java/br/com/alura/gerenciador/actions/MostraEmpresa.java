package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class MostraEmpresa {
    public String mostraEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mostrando dados da empresa");
        String idParameter = request.getParameter("id");
        Integer id = Integer.valueOf(idParameter);
        //System.out.println("Irei editar a empresa de ID: " + id);

        Banco banco = new Banco();
        Optional<Empresa> first = banco.getLista().stream()
                .filter(empresa -> Objects.equals(empresa.getId(), id))
                .findFirst();
        Empresa empresa = first.orElse(null);

        request.setAttribute("empresaNome", empresa.getNome());
        request.setAttribute("empresaData", empresa.getDataCriacao());
        request.setAttribute("id", id);

        return "forward:formEditaEmpresa.jsp";

    }
}
