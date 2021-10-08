package com.dbc;
import java.util.Scanner;
public class exercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jogCadast = 0;
        double Jogadoraltura = 0;
        int maisVelho = 0;
        String nomeMaisVelho = null;
        double maisPesado = 0;
        String nomeMaisPesado = null;
        double soma = 0;
        String nome = null;
        double altura = 0;
        int idade = 0;
        double peso = 0;

        do {
            if (jogCadast == 0) {
                System.out.printf("complete com os nomes dos jogadores: " + "\n");
                System.out.printf("Nome: ");
                nome = input.next();
            }

            System.out.printf("Qual sua Altura: ");
            altura = input.nextDouble();
            System.out.printf(" Qual sua Idade: ");
            idade = input.nextInt();
            System.out.printf(" Qual seu Peso: ");
            peso = input.nextDouble();
            input.next();

            System.out.printf("nome: " + nome +"\n");
            System.out.printf("Altura: " + altura +"\n");
            System.out.printf("Idade: " + idade + "\n");
            System.out.printf("Peso: " + peso + "\n");


            jogCadast++;
            soma += altura;

            if (Jogadoraltura < altura) {
                Jogadoraltura = altura;
            }

            if (idade > maisVelho) {
                maisVelho = idade;
                nomeMaisVelho = nome;
            }

            if (peso > maisPesado) {
                maisPesado = peso;
                nomeMaisPesado = nome;
            }

            System.out.printf("Digite o nome dos jogadores: ");
            System.out.printf("Nome: ");
            nome = input.nextLine();

        } while (!nome.equalsIgnoreCase("sair"));

        double media = soma / jogCadast;

        System.out.printf(" A Quantidade de jogadores cadastrados: " + jogCadast);
        System.out.printf("Jogador mais alto: " + Jogadoraltura);
        System.out.printf("O  mais velho: " + nomeMaisVelho);
        System.out.printf("O mais pesado: " + nomeMaisPesado);
        System.out.printf("Média das alturas dos jogadores: ", media);
    }
}
