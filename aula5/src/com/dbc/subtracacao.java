package com.dbc;

import com.dbc.OperacaoMatematica;

public class subtracacao  implements OperacaoMatematica {

    @Override
    public int getcalcula(int a, int b) {
        return a - b;
    }
}