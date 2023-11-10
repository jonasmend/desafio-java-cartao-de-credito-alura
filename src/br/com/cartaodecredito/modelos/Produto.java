package br.com.cartaodecredito.modelos;

public class Produto implements Comparable<Produto> {

    private String descricao;

    private double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }


    @Override
    public String toString() {
        return this.descricao + " - R$ " + this.valor;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outroProduto.valor));
    }
}
