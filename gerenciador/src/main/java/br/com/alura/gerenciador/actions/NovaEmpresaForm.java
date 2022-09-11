package br.com.alura.gerenciador.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovaEmpresaForm {
    public String criaEmpresa(HttpServletRequest request, HttpServletResponse response) {
        return "forward:formNovaEmpresa.jsp";
    }
}
