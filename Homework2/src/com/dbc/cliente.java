package com.dbc;

public class cliente {
     private String nome;
     private String cpf;
     private contato[] contatos = new contato[2];
     private Endereco[] enderecos = new Endereco[2];

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
    public String getNome(){
        return nome;
    }
    public void setNome(string nome){
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getContatos(){
        return contatos;
    }
    public void setContatos(contatos = new contato[2]){
        this.contatos = contatos;
    }
    public String getEnderecos(){
        return enderecos;
    }
    public void setEnderecos(enderecos = new Endereco[2]){
        this.enderecos = enderecos;
    }
}
