package br.com.cartaodecredito.principal;

import br.com.cartaodecredito.modelos.CartaoDeCredito;
import br.com.cartaodecredito.modelos.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int operacao = 1;
        List<Produto> listaDeProdutosComprados = new ArrayList<>();

        String textoCompraDescricao = "\nDigite o produto que deseja comprar: ";
        String textoCompraValor = "Digite o valor do produto %s: ";
        String textoSelecionarOperacao = "\nDigite 1 para realizar uma nova compra ou 0 para sair: ";
        String textoSaldoInsuficiente = "Saldo insuficiente!";
        String textoCompraRealizada = "Compra efetuada com sucesso!";
        String textoDescricaoDasCompras = """
                \nCOMPRAS REALIZADAS:
                                
                %s
                                
                Saldo do cartão: R$ %.2f
                """;

        System.out.println("Digite o limite do cartão: ");
        CartaoDeCredito cartao = new CartaoDeCredito(leitura.nextDouble());

        while(operacao != 0) {
            System.out.println(textoCompraDescricao);
            String descricaoDaCompra = leitura.next();

            System.out.println(textoCompraValor.formatted(descricaoDaCompra));
            double valorDaCompra = leitura.nextDouble();

            if (cartao.adicionaCompra(new Produto(descricaoDaCompra, valorDaCompra))) {
                System.out.println(textoCompraRealizada);
                System.out.println(textoSelecionarOperacao);
                operacao = leitura.nextInt();
            } else {
                System.out.println(textoSaldoInsuficiente);
                operacao = 0;
            };
        }

        cartao.ordenarListaDeCompras();
        System.out.println(textoDescricaoDasCompras.formatted(cartao.getCompras().toString(), cartao.getSaldo()));
    }
}