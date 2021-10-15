package com.dbc;


    public class ContaPagamento extends Conta implements Impressao {
        final static double TAXA_SAQUE = 4.25;


        @Override
        public boolean sacar(double valorSaque) {
            if (valorSaque + TAXA_SAQUE > this.getSaldo()) {
                System.out.println("Saldo insuficiente");
                return false;
            } else {
                this.setSaldo(this.getSaldo() - (TAXA_SAQUE + valorSaque));
                System.out.println("Saque feito com sucesso");
                return true;
            }
        }

        @Override
        public boolean depositar(double valorDeposito) {
            if (valorDeposito <= 0) {
                System.out.println("impossivel");
                return false;
            } else {
                this.setSaldo(this.getSaldo() + valorDeposito);
                System.out.println("Deposito feito com sucesso");
                return true;
            }
        }

        @Override
        public boolean transferir(Conta conta, double valor) {
            if (this.sacar(valor)) {
                conta.depositar(valor);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void imprimir () {
            System.out.println("Saldo: " + this.getSaldo());

        }
    }

