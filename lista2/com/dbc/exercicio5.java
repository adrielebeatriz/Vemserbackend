


package com.dbc;

import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] v = new int[20];

        System.out.printf("Digite um numero ate 20" + "\n");

        for(int i = 0; i < v.length; i++){
            System.out.printf("Número %d %n", i+1);
            v[i] = input.nextInt();
        }

        for(int i = v.length; i > 0 ; i--){
            System.out.printf("Na posição "+ i +"o número é " + v[i-1]);
        }
    }
}