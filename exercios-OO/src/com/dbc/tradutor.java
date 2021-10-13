package com.dbc;

import java.util.Scanner;

public class tradutor {

    String word;

    Scanner input = new Scanner(System.in);

    public void traduzirPalavra() {
    System.out.println("Diga qual palavra será traduzida: ");
    word = input.next();
    word = word.toUpperCase();

        switch (word) {
            case "CACHORRO":
                System.out.println("A tradução da palavra " + word + " em inglês é Dog");
                break;

            case "DOG":
                System.out.println("A tradução da palavra " + word + " em português é Cachorro");
                break;

            case "TEMPO":
                System.out.println("A tradução da palavra " + word + " em inglês é Time");
                break;

            case "TIME":
                System.out.println("A tradução da palavra " + word + " em português é Tempo");
                break;

            case "AMOR":
                System.out.println("A tradução da palavra " + word + " em inglês é Love");
                break;

            case "LOVE":
                System.out.println("A tradução da palavra " + word + " em português é Amor");
                break;

            case "CIDADE":
                System.out.println("A tradução da palavra  " + word + " em inglês é City");
                break;

            case "CITY":
                System.out.println("A tradução da palavra  " + word + " em portugês é Cidade");
                break;

            case "FELIZ":
                System.out.println("A tradução da palavra  " + word + " em inglês é Happy");
                break;

            case "HAPPY":
                System.out.println("A tradução da palavra" + word + "em português é: Feliz  ");
                break;

            default:
                System.out.println("Palavra invalida");
                break;
        }
    }
}

}
