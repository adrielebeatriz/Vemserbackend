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
        if (this.getSaldo() > valor && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficente. Transferência máxima de: " + (getSaldo()));
        return false;
    }


    @Override
    public void imprimir() {
        System.out.printf("Valor cheque especial: " +chequeesqpecial);
        System.out.printf("Saldo conta corrente: " +  getSaldo());
    }




    @Override
    public Boolean transferir(conta conta, Double valor) {
        if (this.getSaldo() > valor && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficente. Transferência máxima de: " + (getSaldo()));
        return false;

    }
}
