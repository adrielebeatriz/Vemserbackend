package com.dbc;


    public class ContaPoupanca extends Conta implements Impressao {
        final static double JUROS_MENSAL = 1.01;


        public void creditarTaxa() {
            this.setSaldo(this.getSaldo() * JUROS_MENSAL);


        }
        @Override
        public void imprimir() {
            System.out.println("Valor do saldo: " + this.getSaldo());

        }
    }

