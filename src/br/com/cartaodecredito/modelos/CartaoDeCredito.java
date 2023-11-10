package br.com.cartaodecredito.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartaoDeCredito {

    private double limite;

    private double saldo;

    private List<Produto> compras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Produto> getCompras() {
        return compras;
    }

    public boolean adicionaCompra(Produto produto) {
        if(produto.getValor() <= this.saldo) {
            this.compras.add(produto);
            this.saldo -= produto.getValor();
            return true;
        } else {
            return false;
        }
    }

    public void ordenarListaDeCompras() {
        Collections.sort(this.compras);
    }
}
