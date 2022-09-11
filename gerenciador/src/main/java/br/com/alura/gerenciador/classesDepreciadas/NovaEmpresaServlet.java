package br.com.alura.gerenciador.classesDepreciadas;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet(urlPatterns = "/novaempresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        request.setAttribute("empresa", empresa.getNome());
        response.sendRedirect("listaempresa");
//        //repassando para o JSP
//        RequestDispatcher rd = request.getRequestDispatcher("/listaempresa");
//        request.setAttribute("empresa", empresa.getNome());
//        rd.forward(request, response);
    }
}
