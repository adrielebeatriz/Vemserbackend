package com.dbc;

public class contacorrente {
    cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;
     private double chequeespecial;

    public void imprimircontacorrente() {
        System.out.printf("Cliente: " + numeroConta + "\n");
        System.out.printf("Agência: " + agencia);
    }

    public boolean sacar(double saque) {
        if (saque > saldo) {
            return false;
        } else {
            return true;
        }
    }
    public boolean depositar(Double capital){
        if(capital < 1){
            return false;
        }
        else{
            saldo += capital;
            return true;
        }
    }

    public boolean  transferir(contacorrente conta, Double montante){
        if(montante < 1 || montante > saldo){
            return false;
        }
        else{
            sacar(montante);
        }
        return true;
    }

    public String getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }
    public String getAgencia(){
        return agencia;
    }
    public void setAgencia(){
        this.agencia = agencia;
    }
    public String getSaldo(){
        return saldo;
    }
    public void setSaldo(){
        this.saldo = saldo;
    }
    public  String getChequeespecial(){
        return chequeespecial;
    }
    public void setChequeespecial(){
        this.chequeespecial = chequeespecial;
    }
}
