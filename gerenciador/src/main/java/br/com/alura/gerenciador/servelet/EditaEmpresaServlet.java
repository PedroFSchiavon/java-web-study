package br.com.alura.gerenciador.servelet;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

//@WebServlet(urlPatterns = "/editaempresa")
public class EditaEmpresaServlet extends HttpServlet {
    Integer id = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParameter = request.getParameter("id");
        id = Integer.valueOf(idParameter);
        System.out.println("Irei editar a empresa de ID: " + id);

        Banco banco = new Banco();
        Optional<Empresa> first = banco.getLista().stream()
                .filter(empresa -> Objects.equals(empresa.getId(), id))
                .findFirst();
        Empresa empresa = first.orElse(null);

        RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
        request.setAttribute("empresaNome", empresa.getNome());
        request.setAttribute("empresaData", empresa.getDataCriacao());
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Esse id é do post mane = " + id);
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

        response.sendRedirect("listaempresa");
    }
}
