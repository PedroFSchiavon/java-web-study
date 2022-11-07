package br.com.alura.mundi.repository;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.model.StatusPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
