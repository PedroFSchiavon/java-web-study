package br.com.alura.mundi.controller;

import br.com.alura.mundi.dao.PedidoDao;
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
    public String novoProduto(PedidoDao pedidoDao){
        Pedido pedido = pedidoDao.toPedido();
        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }
}
