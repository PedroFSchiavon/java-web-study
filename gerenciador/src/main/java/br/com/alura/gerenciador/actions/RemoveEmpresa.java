package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RemoveEmpresa implements Acao{
    public String run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Removendo empresa");
        String idParaRemover = request.getParameter("id");
        System.out.println("Cheguei aqui, olha meu id = " + idParaRemover);

        Banco banco = new Banco();
        banco.removeEmpresa(Integer.valueOf(idParaRemover));


        return "redirect:entrada?action=ListaEmpresas";
    }
}
