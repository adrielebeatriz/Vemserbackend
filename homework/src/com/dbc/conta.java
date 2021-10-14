package com.dbc;

public abstract class conta implements Movimentacao{
    private static double saldo;

    private double valor;
    private String cliente;
    private String numeroconta;
    private String agencia;

    @Override
    public boolean transferir(conta conta, double valor) {
        if (this.getSaldo() > valor && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficente. Transferência máxima de: " +(getSaldo()));
        return false;
    }

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
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double v){
        saldo = saldo;
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

    public abstract Boolean transferir(Double valor);

    public abstract void imprimir();
}
