package com.dbc;

public class Main {

    public static void main(String[] args) {
        cliente cliente1 = new cliente();
        cliente1.nome = "Daniel Silva";
        cliente1.cpf = "123852987-00";

        contacorrente contadaniel = new contacorrente();
        contadaniel.cliente = cliente1;
        contadaniel.numeroConta = "232918-2";
        contadaniel.agencia = 496;
        contadaniel.saldo = 500;
        contato contatodaniel1= new contato();
        contatodaniel1.descricao = "";
        contatodaniel1.telefone = "3127113736";
        contatodaniel1.tipo = 1;

        contato contatodaniel2 = new contato();
        contatodaniel2 .descricao = "";
        contatodaniel2 .telefone = "31991559237";
        contatodaniel2 .tipo = 2;

        Endereco endereco1 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rua julio cesar";
        endereco1.numero = 17;
        endereco1.complemento = "casa";
        endereco1.cep = "31015050";
        endereco1.cidade = "Belo Horizonte";
        endereco1.estado = "MG";
        endereco1.pais = "BR";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 2;
        endereco2.logradouro = "Rua do campo largo";
        endereco2.numero = 11;
        endereco2.complemento = "casa";
        endereco2.cep = "40050-435";
        endereco2.cidade = "Salvador";
        endereco2.estado = "BA";
        endereco2.pais = "BR";
}
}