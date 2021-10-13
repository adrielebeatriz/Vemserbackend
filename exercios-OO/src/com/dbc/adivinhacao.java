package com.dbc;

import java.util.Scanner;

public class adivinhacao {
    Scanner input = new Scanner(System.in);
    int escolhaCerta;
    int realizacoes = 0;
    int errada;


    public void escolhaNumero() {
        System.out.print("Digite o número da brincadeira: ");
        escolhaCerta = input.nextInt();
        System.out.print("Tente adivinhar o número: ");
        errada = input.nextInt();
    }
        public void Sorteio () {
            while (escolhaCerta != realizacoes) {
                if (realizacoes > escolhaCerta) {
                    System.out.println("O número a ser encontrado é menor do que você digitou");
                } else {
                    System.out.println("O número a ser encontrado é maior do que você digitou");
                }
                System.out.print("Faça uma nova tentativa e digite um número: ");
                realizacoes = input.nextInt();
            }
            System.out.println("Parabéns!");
        }
    }
