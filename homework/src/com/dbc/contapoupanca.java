package com.dbc;

public  class contapoupanca extends conta implements Impressao {
    final static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){
        setSaldo();
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
    public Boolean transferir(Double valor) {
        return null;
    }
}