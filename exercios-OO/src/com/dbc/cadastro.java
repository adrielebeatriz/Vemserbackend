package com.dbc;
import java.util.Scanner;
public class cadastro {

    int escolha;
    int escolhaCidade;

    Scanner scanner = new Scanner(System.in);
    public void escoherEstado() {
        System.out.println("Estados disponiveis:1-Bahia, 2-São Paulo, 3-Rio de Janeiro");
        System.out.println("Escolha um estado: ");
        escolha = scanner.nextInt();
        scanner.nextLine();
        escolhaCidade = 0;
    }
    public void escolhaCidade () {
        switch (escolha) {

            case 1:
                System.out.print("1- Salvador \n" + " 2-Porto Seguro\n");
                System.out.println("Escolha a cidade: ");
                escolhaCidade = scanner.nextInt();
                scanner.nextLine();
                if (escolhaCidade == 1) {
                    System.out.println("Salvador: \n População 2.900.319 habitantes \nidh 0,670 \n Carnaval");
                } else if (escolhaCidade == 2) {
                    System.out.println("Porto Seguro: \nPopulação de 152 529 habitantes \n idh: 0,676 \n Reveillon");
                } else {
                    System.out.println("Digite uma opção válida.");
                }
                break;

            case 2:
                System.out.print("1- Rio de Janeiro \n " + " 2-Níteroi");
                System.out.println("Escolha a cidade: ");
                escolhaCidade = scanner.nextInt();
                scanner.nextLine();
                if (escolhaCidade == 1) {
                    System.out.println("Rio de Janeiro:  6.320.446 habitantes\nIDH: 0,799 \n Carnaval");
                } else if (escolhaCidade == 2) {
                    System.out.println("Niterói: 513 584 habitantes\nIDH: 0,886");
                } else {
                    System.out.println("Digite uma opção válida.");
                }
                break;

            case 3:
                System.out.print("1- São Paulo\n " + " 2-Guarulhos");
                System.out.println("Escolha a cidade: ");
                escolhaCidade = scanner.nextInt();
                scanner.nextLine();
                if (escolhaCidade == 1) {
                    System.out.println(" Sãp Paulo:12,33 milhões \n idh:0,783");
                } else if (escolhaCidade == 2) {
                    System.out.println("Guarulhos:1,392 milhão \n idg:0,717.");
                } else {
                    System.out.println("Digite uma opção válida.");
                }
                break;
            default:
                System.out.println("Digite uma opção válida.");
                break;

        }
    }

}


