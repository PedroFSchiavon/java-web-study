package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditaEmpresa implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Editando empresa");
        String idParameter = request.getParameter("id");
        System.out.println("Olha o id: " + idParameter);
        Integer id = Integer.valueOf(idParameter);
        String nome = request.getParameter("nome");
        String paramData = request.getParameter("data");

        Date data = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data = sdf.parse(paramData);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        banco.editaEmpresa(id, nome, data);


        return "redirect:entrada?action=ListaEmpresas";
    }
}
