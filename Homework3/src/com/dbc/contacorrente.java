package com.dbc;

public class contacorrente {
    cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeespecial;


    public void imprimirContaCorrente() {
        cliente.imprimirClientes();

        System.out.println("Agência: " + this.agencia
                + " Conta: " + this.numeroConta
                + " Saldo: " + this.saldo
                + " Limite Cheque Especial: " + this.chequeespecial + "\n");
    }

    public boolean sacar (double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return (saldo + chequeespecial);
    }

    public boolean transferir(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.depositar(valor);
            this.sacar(valor);
            return true;
        }
        return false;
    }


}