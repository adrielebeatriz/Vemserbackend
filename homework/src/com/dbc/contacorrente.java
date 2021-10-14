package com.dbc;

public class contacorrente extends conta implements Impressao {


    public contacorrente(double saldo) {
        super(saldo);
    }
    private  double chequeesqpecial;

    public contacorrente() {

    }

    public double contacorrente(double saldo){
        return saldo+ chequeesqpecial;
    }
    public void setChequeespecial(double v){
        this.chequeesqpecial= chequeesqpecial;
    }
    @Override
    public Boolean sacar(Double saque){
        if(saque > chequeesqpecial || saque < 1){
            return false;
        }
        else{
            chequeesqpecial -= saque;
            return true;
        }
    }

    @Override
    public Boolean transferir(Double valor) {
        return null;
    }

    @Override
    public void imprimir() {
        System.out.printf("Valor cheque especial: " +chequeesqpecial);
        System.out.printf("Saldo conta corrente: " +  getSaldo());
    }

    public void setSaldo() {
    }
}
