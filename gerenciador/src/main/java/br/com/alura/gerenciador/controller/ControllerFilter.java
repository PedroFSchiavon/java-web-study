package br.com.alura.gerenciador.controller;

import br.com.alura.gerenciador.actions.Acao;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

public class ControllerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ControllerFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");
        String nomeCompletoClasse = "br.com.alura.gerenciador.actions." + paramAction;
        String nome = null;

        try {
            Class<?> classe = Class.forName(nomeCompletoClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.run(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
            throw new ServletException(exception);
        }

        String[] entradaENome = nome.split(":");

        if(Objects.equals(entradaENome[0],"forward")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + entradaENome[1]);
            rd.forward(request, response);
        }else{
            response.sendRedirect(entradaENome[1]);
        }
    }
}
