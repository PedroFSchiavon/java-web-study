package br.com.alura.mundi.dao;

import br.com.alura.mundi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDao {
    private String nomeProduto;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);

        return pedido;
    }
}
