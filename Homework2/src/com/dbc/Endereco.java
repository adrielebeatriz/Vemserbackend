package com.dbc;

public class Endereco {
     private Integer tipo;
     private String logradouro;
     private Integer numero;
     private String complemento;
     private String cep;
     private String cidade;
     private String estado;
     private String pais;

    public void imprimirEndereco() {

        System.out.println(this.logradouro + this.numero +this.cep+ this.complemento+ this.cidade + this.estado + this.pais);
    }
    public  String getTipo(){
        return tipo;
    }
    public void setTipo(){
        this.tipo = tipo;
    }
    public  String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro( String logradouro){
        this.logradouro = logradouro;
    }
    public  String getNumero() {
        return numero;
    }
    public void setNumero( String numero) {
        this.numero = numero;
    }
    public  String getComplemento() {
        return complemento;
    }
    public void setComplemento( String complemento) {
        this.complemento = complemento;
    }
    public  String getCep() {
        return cep;
    }
}
    public void setCep( String cep) {
        this.cep = cep;
    }
    public  String getCidade() {
        return cidade;
    }

    public void setCidade( String cidade) {
        this.cidade = cidade;
    }
    public  String getEstado() {
        return estado;
    }

    public void setEstado( String estado) {
        this.estado = estado;
    }
    public  String getPais() {
        return pais;
    }
    public void setPais( String pais) {
        this.pais = pais;
    }
}