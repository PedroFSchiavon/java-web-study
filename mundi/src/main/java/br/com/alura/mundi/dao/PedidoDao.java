package br.com.alura.mundi.dao;

import br.com.alura.mundi.model.Pedido;
import br.com.alura.mundi.model.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PedidoDao {
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);

        return pedido;
    }
}
