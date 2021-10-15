package com.dbc;
public class Contato {
    private String descricao;
    private String telefone;
    private int tipo; // (1- residencial, 2- comercial)


    public void imprimirContato(){
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Tipo: " + this.getTipo());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}