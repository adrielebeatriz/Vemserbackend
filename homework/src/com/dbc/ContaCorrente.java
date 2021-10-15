package com.dbc;


    public class ContaCorrente extends Conta implements Impressao {
        private double chequeEspecial;

        public double getChequeEspecial() {
            return chequeEspecial;
        }

        public void setChequeEspecial(double chequeEspecial) {
            this.chequeEspecial = chequeEspecial;
        }

        public double retornarSaldoComChequeEspecial() {
            return this.getSaldo() + this.getChequeEspecial();
        }


        @Override
        public boolean sacar(double valorSaque) {
            if (valorSaque > this.retornarSaldoComChequeEspecial()) {
                System.out.println("Saldo insuficiente");
                return false;
            } else {
                this.setSaldo(this.getSaldo() - valorSaque);
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
        public void imprimir() {
            System.out.println("Saldo + cheque especial: " + this.retornarSaldoComChequeEspecial());
        }
    }

