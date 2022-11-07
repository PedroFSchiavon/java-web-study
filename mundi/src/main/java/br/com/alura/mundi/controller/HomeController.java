package br.com.alura.mundi.controller;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.model.StatusPedido;
import br.com.alura.mundi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {
    private final PedidoRepository pedidoRepository;

    public HomeController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    @GetMapping()
    public String home(Model model){
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();

        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable String status, Model model){
        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

}
