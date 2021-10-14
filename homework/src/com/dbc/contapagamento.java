package com.dbc;

public class contapagamento extends conta implements Impressao {
    final static Double TAXA_SAQUE = 4.25;

    @Override
    public Boolean sacar(Double saque) {
        if(TAXA_SAQUE + saque < getSaldo()) {
            setSaldo(getSaldo() - TAXA_SAQUE - saque);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Boolean transferir(Double valor) {
        return null;
    }

    @Override
    public void imprimir() {
        System.out.printf("Saldo conta pagamento: R$%.2f %n%n", getSaldo());
    }

    public double getSaldo() {
        double saldo = 0;
        return saldo;
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
