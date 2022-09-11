package br.com.alura.gerenciador.actions;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NovaEmpresaForm implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        return "forward:formNovaEmpresa.jsp";
    }
}
