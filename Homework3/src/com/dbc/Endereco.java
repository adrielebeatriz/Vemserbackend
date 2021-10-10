package com.dbc;

public class Endereco {
    Integer tipo;
    String logradouro;
    Integer numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco() {

        System.out.println(this.logradouro + this.numero +this.cep+ this.complemento+ this.cidade + this.estado + this.pais);
    }
}