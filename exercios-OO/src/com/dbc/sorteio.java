package com.dbc;

import java.util.Scanner;

public class sorteio {


    int p = new int[3];

    Scanner input = new Scanner(System.in);


    public void  digiteNumero() {
        System.out.print("digite 3 numeros: " + "\n");

        for (int i = 0; i < p.length; i++) {
            System.out.printf("Número %d %n", i + 1);
            p[i] = input.nextInt();
        }

        if (p[0] < p[1] && p[0] < p[2]) {
            System.out.print("Você ficou na Posição 0 " + "\n");
        } else if (p[1] < p[0] && p[1] < p[2]) {
            System.out.print("Você ficou na Posição 1 " + "\n");
        } else {
            System.out.print("Você ficou na Posição 2" + "\n");
        }
    }

}
