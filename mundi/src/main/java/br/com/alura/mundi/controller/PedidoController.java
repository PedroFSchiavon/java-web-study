package br.com.alura.mundi.controller;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    private final PedidoRepository pedidoRepository;

    public  PedidoController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    @GetMapping("formulario")
    public String formulario(){
        return "pedido/formulario";
    }
    @PostMapping("novo")
    public String novoProduto(Model model){
        String nomeProduto = (String) model.getAttribute("nomeProduto");
        String urlProduto = (String) model.getAttribute("urlProduto");
        String urlImagem = (String) model.getAttribute("urlImagem");
        String descricao = (String) model.getAttribute("descricao");

        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        if(!descricao.isEmpty()){
            pedido.setDescricao(descricao);
        }


        return "home";
    }
}
