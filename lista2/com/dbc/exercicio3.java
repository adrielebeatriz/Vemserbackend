package com.dbc;

import java.util.Scanner;

    public class exercicio3 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.println("Digite o valor pago");
            double valorpago = input.nextDouble();
            System.out.println("Digite o valor consumido");
            double consumido = input.nextDouble();
            double troco = valorpago - consumido;
            if (valorpago < consumido) {
                System.out.println(" O valor pago deve ser maior ou igual ao valor consumido");
            } else if (valorpago >= consumido) {
                System.out.println("seu troco é:" + troco + "\n");
            }
        }
    }