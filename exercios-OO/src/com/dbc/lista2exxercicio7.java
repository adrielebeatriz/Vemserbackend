package com.dbc;

import java.util.Scanner;

public class lista2exxercicio7 {


    int[][] m = new int[4][4];
    int loading = 0;


    Scanner input = new Scanner(System.in);

        public void coletarnumeros(){
        for(int i = 0; i < m.length; i++){
        for(int l = 0; l < m.length; l++) {
            System.out.print("Informe um número para a linha: " +(i+1)+ "coluna: " + (l+1));
            m[i][l] = input.nextInt();
            input.nextLine();

            if (m[i][l] > 10) {
                loading++;
            }
        }
    }

        for(int i = 0; i < m.length; i++){
        for(int j = 0; j < m.length; j++) {
            System.out.print(m[i][j] + "\t");
        }
        System.out.println("");
    }
        System.out.print("A quantidade de valores maiores do que 10 é de: " + loading);
}
}
