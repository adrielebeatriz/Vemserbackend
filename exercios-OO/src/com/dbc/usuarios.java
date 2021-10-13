package com.dbc;

import java.util.Scanner;

public class usuarios {

    String nome;
    int idade;
    String cidade;
    String estado;
        Scanner input = new Scanner(System.in);


        public void coletarDados() {
            System.out.println("Digite seu nome: ");
            nome = input.nextLine();

            System.out.println("Digite seu nome: ");
            nome = input.nextLine();
            System.out.println("qual sua idade?");
            idade = input.nextInt();
            input.nextLine();
            System.out.println("qual sua cidade? \n");
            cidade = input.nextLine();
            System.out.println("qual seu estado? \n");
            estado = input.nextLine();
        }
       System.out.printf("OLá, seu nome é " + nome +  " você tem " +idade+ " anos, é da cidade de " +cidade+ " Situada no estado da " +estado+ "\n");
    }




