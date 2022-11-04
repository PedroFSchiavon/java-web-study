package br.com.alura.mundi.service;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> retornaTodosPedidos(){
        return (List<Pedido>) pedidoRepository.findAll();
    }

    public void salvarPedido(Pedido pedido){
        pedidoRepository.save(pedido);
    }
}
