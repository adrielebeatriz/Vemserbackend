package com.dbc;

public class contacorrente {
    cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeespecial;

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
}
