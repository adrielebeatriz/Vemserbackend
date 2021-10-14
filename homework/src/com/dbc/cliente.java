package com.dbc;

public class cliente {
    private String nome;
    private String cpf;
    private contato[] contatos = new contato[2];
    private enderecos[] enderecos = new enderecos[2];

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
    public void setNome(){
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(){
        this.cpf = cpf;
    }
    public contato[] getContatos(){
        return contatos;
    }
    public void setContatos(){
        this.contatos = contatos;
    }
    public enderecos[] getEnderecos(){
        return enderecos;
    }
    public void setEnderecos(){
        this.enderecos = enderecos;
    }
}


