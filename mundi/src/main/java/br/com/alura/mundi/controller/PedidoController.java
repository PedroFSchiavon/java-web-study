package br.com.alura.mundi.controller;

import br.com.alura.mundi.dao.PedidoDao;
import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    private final PedidoRepository pedidoRepository;

    public  PedidoController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    @GetMapping("formulario")
    public String formulario(PedidoDao pedidoDao){
        return "pedido/formulario";
    }
    @PostMapping("novo")
    public String novoProduto(@Valid PedidoDao pedidoDao, BindingResult result){
        if(result.hasErrors()){
            return "pedido/formulario";
        }
        Pedido pedido = pedidoDao.toPedido();
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
