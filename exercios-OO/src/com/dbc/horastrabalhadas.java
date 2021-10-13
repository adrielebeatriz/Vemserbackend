package com.dbc;
import java.util.Scanner;
public class horastrabalhadas {

    double valorhora;
    double qtdhoras;
    double qtdhoras50;
    double qtdhoras100;
    double salariobruto;
    public void calcularHora() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor da hora");
        valorhora = input.nextDouble();

        System.out.println("Digite a qantidade de horas normais");
        qtdhoras = input.nextDouble();


        System.out.println("DSigite a uanidade de horas extras");
        qtdhoras50 = input.nextDouble();

        System.out.println("Digite a quantidade de horas extras");
        qtdhoras100 = input.nextDouble();
        salariobruto = (qtdhoras * valorhora) + ((qtdhoras * valorhora) * 1.5) +
                ((qtdhoras * valorhora) * 2.0);
        System.out.print("salario bruto: ");
        System.out.println(salariobruto);
    }
}
