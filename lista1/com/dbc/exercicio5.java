package com.dbc;

import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor da hora");
        double valorhora = input.nextDouble();

        System.out.println("Digite a qantidade de horas normais");
        double qtdhoras = input.nextDouble();


        System.out.println("Digite a quantidade de horas extras");
        double qtdhoras50 = input.nextDouble();

        System.out.println("Digite a quantidade de horas extras");
        double qtdhoras100 = input.nextDouble();
        double salariobruto = (qtdhoras * valorhora) + ((qtdhoras * valorhora)* 1.5)+
                ((qtdhoras * valorhora)*2.0);
        System.out.print("salario bruto: ");
        System.out.println(salariobruto);
    }
}
