package com.dbc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        usuarios usuario1;
        usuario1 = new usuarios();
        usuario1.nome = "Daniel";
        usuario1.cidade = "Salvador";
        usuario1.estado = "Bahia";
        usuario1.idade = 68;

        mediaAlunos mediaAlunos1 = null;
        mediaAlunos1.nota1 = 7;
        mediaAlunos1.nota2 = 7;
        mediaAlunos1.nota3 = 8;
        mediaAlunos1.nota4 = 9;
        mediaAlunos1.media = 7.75;

        valorpago valorpago1 = null;
        valorpago1.valorPago = 50;
        valorpago1.consumido = 40;
        valorpago1.troco = 10;

        cadastro cadastro1 = null;
        cadastro1.escolha = 1;
        cadastro1.escolhaCidade = 1;

        cadastro cadastro2 = null;
        cadastro2.escolha = 2;
        cadastro2.escolhaCidade = 2;

        horastrabalhadas ht1 = null;
        ht1.valorhora = 30;
        ht1.qtdhoras = 8;
        ht1.qtdhoras50 = 4;
        ht1.qtdhoras100 = 4;
        ht1.salariobruto = 1215;

        catalogodeProdutos catalogodeProdutos1 = null;
        catalogodeProdutos1.nomeP = "jessy";
        catalogodeProdutos1.preco = 15;
        catalogodeProdutos1.promocao = 12;

        adivinhacao adivinhacao1 = null;
        adivinhacao1.escolhaCerta = 10;
        adivinhacao1.errada = 15;
        adivinhacao1.realizacoes = 10;

        cadastroJogadores cadastroJogadores1 = null;
        cadastroJogadores1.jogCadast = 10;
        cadastroJogadores1.nomeMaisPesado = "Jonas";
        cadastroJogadores1.nome = "";
        cadastroJogadores1.idade = 23;
        cadastroJogadores1.maisPesado = 70;
        cadastroJogadores1.nomeMaisVelho = "Daniel";

        sorteio sorteio1 = null;
        sorteio1.p = 10;

        adiviinhar adiviinhar1 = null;
        adiviinhar1.v = 20;

        lista2exercicio6 l2 = null;
        l2.valor = 20;
        l2.v = new int[]{2, 10, 17, 35, 16, 40, 60, 50, 20, 30};

        lista2exxercicio7 l7 = null;
        l7.m =  new int[4][4];
        l7.loading = 0;

        lista2exercicio8 l8 = null;
        l8.matriculaComMaiorNotaFinal = 0;
        l8.matr = 0;
        l8.m =new int[5][4];
        l8.mp = 0;
        l8.mt = 0;
        l8.maiorNotaFinal = 0;
        l8.nf =0;
        l8.snf = 0;
        l8.totmat = 0;
    }
}