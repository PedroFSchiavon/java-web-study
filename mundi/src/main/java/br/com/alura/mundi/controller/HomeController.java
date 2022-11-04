package br.com.alura.mundi.controller;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    private final PedidoService pedidoService;

    public HomeController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
    @GetMapping("home")
    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Echo Dot (4ª geração)");
        pedido.setValorProduto(new BigDecimal("474.05"));
        pedido.setDescricao("Echo dot para brincar com a Alexa.");
        pedido.setUrlProduto("https://a.co/d/eTrQWnA");
        pedido.setUrlImagem("https://m.media-amazon.com/images/G/32/kindle/journeys/iV1CzUyRmVKybt2BpNmwhiKnSOoteP2ngQasLI6fLA2BM3D/NmVmNzYwYTYt._CB404332222_.jpg");
        pedido.setDataEntrega(LocalDate.now());

        //pedidoService.salvarPedido(pedido);
        List<Pedido> pedidos = pedidoService.retornaTodosPedidos();

        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
