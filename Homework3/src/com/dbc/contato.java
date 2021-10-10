package com.dbc;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class contato {
    String descricao;
    String telefone;
    int tipo;
    public void imprimirContato(){
        System.out.println("Contato: " + telefone);
        System.out.println("Descrição: " + descricao;
        System.out.println("Tipo de contato:"  + tipo);
    }
}
