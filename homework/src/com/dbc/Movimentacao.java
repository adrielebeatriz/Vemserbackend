package com.dbc;

public interface Movimentacao {
    boolean transferir(conta conta, double valor);

    public boolean sacar(double valor);
    public boolean depositar(double valor);
    Boolean transferir( conta conta, Double valor);
}
