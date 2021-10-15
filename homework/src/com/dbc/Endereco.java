package com.dbc;


public class Endereco {
    private int tipo; // 1- residencial / 2 - comercial;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public void imprimirEndereco(){
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Logradouro: " + this.getLogradouro());
        System.out.println("Numero: " + this.getNumero());
        System.out.println("Complemento: " + this.getComplemento());
        System.out.println("CEP: "+ this.getCep());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("País: " + this.getPais());


    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}