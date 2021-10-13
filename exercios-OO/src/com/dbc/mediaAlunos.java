package com.dbc;
import java.util.Scanner;
public class mediaAlunos {
    Scanner input = new Scanner(System.in);
    double nota1;
    double nota2;
    double nota3;
    double nota4;
    double media;
        public void coletarNotas() {
            // recebe a 1º nota
            System.out.println("Aluno, digite sua 1ª nota");
            nota1 = input.nextDouble();

            // recebe a 2º nota
            System.out.println("Aluno, digite sua 2ª nota");
            nota2 = input.nextDouble();

            // recebe a 3º nota
            System.out.println("Aluno, digite sua 3ª nota");
            nota3 = input.nextDouble();

            System.out.println("Aluno, digite sua 4ª nota");
            nota4 = input.nextDouble();


            // calcula a média
            public void calcularMedia () {
                media = (nota1 + nota2 + nota3 + nota4) / 4;
                System.out.println("A média do aluno  é " + media);

                // mostra a nota do aluno
                if (media <= 5) {
                    System.out.println(" reprovado");
                } else if (media >= 5.0 && media <= 6.0) {
                    System.out.println("em exame");
                } else {
                    System.out.println("Aprovado");

                }
            }

        }