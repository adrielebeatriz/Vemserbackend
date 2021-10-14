package com.dbc;


public class contato {
    private  String descricao;
    private String telefone;
    private int tipo;
    public void imprimirContato(){
        System.out.println("Contato: " + telefone);
        System.out.println("Descrição: " + descricao);
        System.out.println("Tipo de contato:"  + tipo);
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(){
        this.descricao = descricao;
    }

    public String getTelefone (){
        return telefone;
    }
    public void setTelefone ( ){
        this.telefone = telefone;
    }
    public int getTipo(){
        return tipo;
    }
    public void setTipo(){
        this.tipo = tipo;
    }


}
