package br.com.alura.mundi.controller;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final PedidoRepository pedidoRepository;

    public HomeController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    @GetMapping("home")
    public String home(Model model){
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();

        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
