package br.com.alura.mundi.controller;

import br.com.alura.mundi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Echo Dot (4ª geração)");
        pedido.setValorProduto(new BigDecimal("474.05"));
        pedido.setDescricao("Echo dot para brincar com a Alexa.");
        pedido.setUrlProduto("https://www.amazon.com.br/Novo-Echo-Dot-com-rel%C3%B3gio/dp/B084J4WP6J/?_encoding=UTF8&pd_rd_w=gG4Bt&content-id=amzn1.sym.1c4f2e65-cd11-4cd4-86f1-9372e9be93f8&pf_rd_p=1c4f2e65-cd11-4cd4-86f1-9372e9be93f8&pf_rd_r=RM0RYZC1HN8G23C35445&pd_rd_wg=UvhUj&pd_rd_r=856846e2-a73f-42df-8787-531f5c099516&ref_=pd_gw_unk");
        pedido.setUrlImagem("https://files.tecnoblog.net/wp-content/uploads/2020/12/Amazon-Echo-Dot-4-4-1060x596.jpg");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
