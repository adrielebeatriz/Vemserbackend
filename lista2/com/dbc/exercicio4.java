package com.dbc;
import java.util.Scanner;
public class exercicio4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] p = new int[3];

        System.out.print("digite 3 numeros: " + "\n");

        for(int i = 0; i < p.length; i++){
            System.out.printf("Número %d %n", i+1);
            p[i] = input.nextInt();
        }

        if (p[0] < p[1] && p[0] < p[2]) {
            System.out.print("Você ficou na Posição 0 " + "\n");
        }
        else if(p[1] < p[0] && p[1] < p[2]){
            System.out.print("Você ficou na Posição 1 " + "\n");
        }
        else{
            System.out.print("Você ficou na Posição 2" + "\n");
        }


    }
}
