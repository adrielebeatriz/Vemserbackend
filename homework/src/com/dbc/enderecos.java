package com.dbc;

public class enderecos {
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
    public  int getTipo(){
        return tipo;
    }
    public void setTipo(int i){
        this.tipo = tipo;
    }
    public  String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String i){
        this.logradouro = logradouro;
    }
    public  int getNumero() {
        return numero;
    }
    public void setNumero(int i) {
        this.numero = numero;
    }
    public  String getComplemento() {
        return complemento;
    }
    public void setComplemento(String casa) {
        this.complemento = complemento;
    }
    public  String getCep() {
        return cep;
    }

    public void setCep(String s) {
        this.cep = cep;
    }
    public  String getCidade() {
        return cidade;
    }

    public void setCidade(String salvador) {
        this.cidade = cidade;
    }
    public  String getEstado() {
        return estado;
    }

    public void setEstado(String ba) {
        this.estado = estado;
    }
    public  String getPais() {
        return pais;
    }
    public void setPais(String brasil) {
        this.pais = pais;
    }
}
