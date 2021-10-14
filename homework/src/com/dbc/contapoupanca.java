package com.dbc;

public abstract class contapoupanca extends conta implements Impressao {
    final static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){
        double JUROS_MENSAIS = 0;
        setSaldo(getSaldo()*JUROS_MENSAIS);
    }


    @Override
    public Boolean sacar(Double saque) {
        return null;
    }

    @Override
    public void imprimir() {
        System.out.printf("Saldo conta poupança: R$%.2f %n", getSaldo());

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