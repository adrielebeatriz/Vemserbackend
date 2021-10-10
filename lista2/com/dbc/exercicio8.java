package com.dbc;
import java.util.Scanner;
public class exercicio8 {
    Scanner input = new Scanner(System.in);

    int m [][] = new int[5][4];

    int matr = 0;
    int mp = 0;
    int mt = 0;
    int nf = 0;
    int maiorNotaFinal = 0;
    int matriculaComMaiorNotaFinal = 0;
    int snf = 0;
    int totmat = 0;

       for (int i = 0; i < 5; i++) {
        System.out.println("Numero da matrícula");
        m[i][0] = input.nextInt();
        input.nextLine();

        System.out.println("Média das provas");
        m[i][1] = input.nextInt();
        input.nextLine();

        System.out.println("Média dos trabalhos");
        m[i][2] = input.nextInt();
        input.nextLine();

        m[i][3] = (int) ((m[i][1] * 0.6) + (m[i][2] * 0.4));
        if (m[i][3] > maiorNotaFinal) {
            maiorNotaFinal = m[i][3];
            matriculaComMaiorNotaFinal = m[i][0];
        }

        snf+= m[i][3];
    }

        System.out.print("matrícula com maior nota final: " + matriculaComMaiorNotaFinal);
        System.out.print("média das notas finais: " + snf / 5);
}

