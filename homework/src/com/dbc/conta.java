package com.dbc;

public abstract class conta implements Movimentacao{
    private double valor;
    private double saldo;
    private String cliente;
    private String numeroconta;
    private String agencia;

    public conta(double saldo) {
    }

    public conta() {

    }

    public void numeroconta(double saldo) {
    }


    @Override
    public boolean sacar(double valor) {

        if(  saldo > valor)
        return false;
        else{
            return true;
        }
    }

    @Override
    public boolean depositar(double valor) {

        return true;
    }
    public double getValor(){
        return valor;
    }
    public void setValor(){
        this.valor = valor;
    }
    public  double getSaldo() {
        return saldo;
    }
    public void setSaldo(){
        this.saldo = saldo;
    }
    public String getCliente(){
        return cliente= cliente;
    }
    public void setCliente(){
        this.cliente = cliente;
    }
    public String getConta(){
        return numeroconta;
    }
    public void setNumeroconta(){
        this.numeroconta = numeroconta;
    }
    public String getAgencia(){
        return agencia;
    }
    public void setAgencia(){
        this.agencia = agencia;
    }

    public abstract Boolean sacar(Double saque);

    public abstract void imprimir();
}
