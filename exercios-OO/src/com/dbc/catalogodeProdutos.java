package com.dbc;

import java.util.Scanner;

public class catalogodeProdutos {

    String nomeP;
    double preco = 0;
    double promocao = 0;
    Scanner input = new Scanner(System.in);

    public void escolherProduto() {
        System.out.println("Escolha um produto: ");
        nomeP = input.next();
        System.out.println("Agora, fale o valor: ");
        preco = input.nextDouble();
        for (int i = 1; i <= 10; i++) {

            promocao = preco - preco * 0.05 * i;
            System.out.println(promocao + "," + promocao * i);
        }
        System.out.println("O produto: " + nomeP + "   No varejo: " + preco + "   Com a oferta: " + promocao);
    }
}