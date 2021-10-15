package com.dbc;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta() {
        super();
    }

    @Override
    public boolean sacar(double valorSaque) {
        if (valorSaque > this.getSaldo()) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}