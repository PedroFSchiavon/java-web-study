package br.com.alura.gerenciador.servelet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/novaempresa")
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

        empresa.setNome(novaEmpresa);
        empresa.setDataCriacao(dataCriacao);

        Banco banco = new Banco();
        banco.adiciona(empresa);
        System.out.println("Empresa cadastrada com sucesso!" + empresa.getNome());

        //repassando para o JSP
        RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);
    }
}
