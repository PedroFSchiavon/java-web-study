package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao{
    public String run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Cadastrando nova empresa");
        String novaEmpresa = request.getParameter("nome");
        String paramDataCriacao = request.getParameter("data");

        Empresa empresa = new Empresa();
        Date dataCriacao = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataCriacao = sdf.parse(paramDataCriacao);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        empresa.setId(Empresa.getIdIncrementavel());
        empresa.setNome(novaEmpresa);
        empresa.setDataCriacao(dataCriacao);

        Banco banco = new Banco();
        banco.adiciona(empresa);
        System.out.println("Empresa cadastrada com sucesso!" + empresa.getNome() + "ID: " + empresa.getId());

        return "redirect:entrada?action=ListaEmpresas";
    }
}
