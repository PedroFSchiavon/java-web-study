package br.com.alura.loja.vo;

import java.time.LocalDate;

public class RelatorioVendasVO {
    private String nomeDoProduto;
    private long quantidadeDeVendas;
    private LocalDate dataDaUltimaVenda;

    public RelatorioVendasVO(String nomeDoProduto, long quantidadeDeVendas, LocalDate dataDaUltimaVenda) {
        this.nomeDoProduto = nomeDoProduto;
        this.quantidadeDeVendas = quantidadeDeVendas;
        this.dataDaUltimaVenda = dataDaUltimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioVendasVO{" +
                "nomeDoProduto='" + nomeDoProduto + '\'' +
                ", quantidadeDeVendas=" + quantidadeDeVendas +
                ", dataDaUltimaVenda=" + dataDaUltimaVenda +
                '}';
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public long getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }

    public LocalDate getDataDaUltimaVenda() {
        return dataDaUltimaVenda;
    }
}
