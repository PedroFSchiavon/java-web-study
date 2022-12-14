package br.com.alura.gerenciador.actions;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AutenticaLogin implements Acao{
    @Override
    public String run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("Login: " + login + " ---- Senha: " + password);
        Banco banco = new Banco();
        Usuario usuario = banco.validaLogin(login, password);

        if(usuario != null) {
            System.out.println("Usuario autenticado com sucesso.");
            HttpSession session = request.getSession();
            session.setAttribute("usuarioAutenticado", usuario);
            return "redirect:entrada?action=ListaEmpresas";
        }else{
            System.out.println("Usuario nao identificado");
            return "redirect:entrada?action=LoginForm";
        }
    }
}
