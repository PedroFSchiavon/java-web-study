package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RemoveEmpresa {
    public void removeEmpresa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParaRemover = request.getParameter("id");
        System.out.println("Cheguei aqui, olha meu id = " + idParaRemover);

        Banco banco = new Banco();
        banco.removeEmpresa(Integer.valueOf(idParaRemover));

        response.sendRedirect("entrada?action=lista-empresas");
    }
}
