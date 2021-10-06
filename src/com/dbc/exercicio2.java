package com.dbc;
import java.util.Scanner;
public class exercicio2 {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        double nota1;
        double nota2;
        double nota3;
        double nota4;
        double media;
        {

            // recebe a 1º nota
            System.out.println("Aluno, digite sua 1ª nota");
            nota1 = ent.nextDouble();

            // recebe a 2º nota
            System.out.println("Aluno, digite sua 2ª nota");
            nota2 = ent.nextDouble();

            // recebe a 3º nota
            System.out.println("Aluno, digite sua 3ª nota");
            nota3 = ent.nextDouble();

            System.out.println("Aluno, digite sua 4ª nota");
            nota4 = ent.nextDouble();


            // calcula a média
            media = (nota1 + nota2 + nota3 + nota4) / 4;
            System.out.println("A média do aluno  é " +media);

            // mostra a nota do aluno
            if ( media <=5) {
                System.out.println(" reprovado");
            } else if (media >= 5.0 && media <= 6.0 ){
                System.out.println("em exame");
            } else {
                System.out.println("Aprovado");

            }
        }
    }
}

