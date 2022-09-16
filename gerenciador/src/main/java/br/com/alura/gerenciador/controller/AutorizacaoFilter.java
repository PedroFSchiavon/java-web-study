package br.com.alura.gerenciador.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AutorizacaoFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");
        HttpSession session = request.getSession();
        boolean usuarioNaoLogado = session.getAttribute("usuarioAutenticado") == null;
        boolean actionsProibidas = !(Objects.equals(paramAction, "LoginForm") || Objects.equals(paramAction, "AutenticaLogin"));

        if (actionsProibidas && usuarioNaoLogado) {
            response.sendRedirect("entrada?action=LoginForm");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
