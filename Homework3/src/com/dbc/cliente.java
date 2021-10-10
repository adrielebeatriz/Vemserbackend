package com.dbc;

public class cliente {
    String nome;
    String cpf;
    contato[] contatos = new contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        System.out.printf("Contato: " + contatos );

    }
    public void imprimirEnderecos(){
        System.out.println("Endereço: "+enderecos);
    }
    public void imprimirClientes(){
        System.out.printf("Nome: " + nome);
        System.out.printf("CPF: "+ cpf);
    }
}
