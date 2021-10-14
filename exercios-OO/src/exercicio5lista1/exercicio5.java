package exercicio5lista1;

import java.util.Scanner;

public class exercicio5 {
    private double valorhora;
    private double qtdhoras;
    private double qtdhoras50;
    private double qtdhoras100;
    private  double salariobruto;

    public void calcularSalario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor da hora");
         valorhora = input.nextDouble();

        System.out.println("Digite a qantidade de horas normais");
         qtdhoras = input.nextDouble();


        System.out.println("Digite a quantidade de horas extras");
         qtdhoras50 = input.nextDouble();

        System.out.println("Digite a quantidade de horas extras");
         qtdhoras100 = input.nextDouble();
         salariobruto = (qtdhoras * valorhora) + ((qtdhoras * valorhora)* 1.5)+
                ((qtdhoras * valorhora)*2.0);
        System.out.print("salario bruto: ");
        System.out.println(salariobruto);
    }
}
