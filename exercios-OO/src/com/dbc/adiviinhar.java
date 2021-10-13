package com.dbc;

import java.util.Scanner;

public class adiviinhar {



    int v = new int[20];

    Scanner input = new Scanner(System.in);

    public void coletardados() {
        System.out.printf("Digite um numero ate 20" + "\n");

        for (int i = 0; i < v.length; i++) {
            System.out.printf("Número %d %n", i + 1);
            v[i] = input.nextInt();
        }

        for (int i = v.length; i > 0; i--) {
            System.out.printf("Na posição " + i + "o número é " + v[i - 1]);
        }
    }

}