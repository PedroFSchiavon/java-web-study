package br.com.alura.gerenciador.controller;

import jakarta.servlet.*;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MonitoramentoFilter");
        long inicio = System.currentTimeMillis();

        String action = servletRequest.getParameter("action");

        filterChain.doFilter(servletRequest, servletResponse);

        long termino = System.currentTimeMillis();

        System.out.println("Tempo de execução da action " + action + " foi de " + (termino - inicio));
    }
}
