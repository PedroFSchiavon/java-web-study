package br.com.alura.gerenciador.controller;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasServlet", value = "/empresas")
public class EmpresasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String format = request.getParameter("format");
        String respostaApi = null;
        String valor = request.getHeader("Accept");
        List<Empresa> lista = new Banco().getLista();

        if(format.equals("json")){
            Gson gson = new Gson();
            respostaApi = gson.toJson(lista);
            response.setContentType("application/json");
        } else if (format.equals("xml")) {
            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            respostaApi = xStream.toXML(lista);
            response.setContentType("application/xml");
        }else {
            return;
        }   

        response.getWriter().print(respostaApi);
    }
}
