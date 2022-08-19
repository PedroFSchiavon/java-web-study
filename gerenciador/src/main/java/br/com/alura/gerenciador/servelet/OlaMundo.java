package br.com.alura.gerenciador.servelet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/oi")
public class OlaMundo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Hello, world! Esse é o meu primeiro servelet.");
        out.println("</body>");
        out.println("</html>");

        System.out.println("Cheguei aqui em! Deu tudo certo");
    }
}
