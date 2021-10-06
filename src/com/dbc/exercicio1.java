package com.dbc;
import java.util.Scanner;


public class exercicio1 {
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            System.out.println("Digite seu nome: ");
            String nome = input.nextLine();
            System.out.println("qual sua idade?");
            int idade = input.nextInt();
            input.nextLine();
            System.out.println("qual sua cidade? \n");
            String cidade = input.nextLine();
            System.out.println("qual seu estado? \n");
            String estado = input.nextLine();
            System.out.printf("OLá, seu nome é " + nome +  " você tem " +idade+ " anos, é da cidade de " +cidade+ " Situada no estado da " +estado+ "\n");

        }
    }

