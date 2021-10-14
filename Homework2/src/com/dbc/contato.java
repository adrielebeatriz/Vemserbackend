package com.dbc;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class contato {
   private  String descricao;
     private String telefone;
     private int tipo;
    public void imprimirContato(){
        System.out.println("Contato: " + telefone);
        System.out.println("Descrição: " + descricao;
        System.out.println("Tipo de contato:"  + tipo);
    }
    public string getDescricao(){
         return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descrição;
    }

    public string getTelefone (){
        return telefone;
}
    public void setTelefone ( String telefone){
        this.telefone = telefone;
}
     public  String getTipo(){
        return tipo;
}
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}