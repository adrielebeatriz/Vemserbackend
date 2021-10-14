package com.dbc;

public class Main {

    public static void main(String[] args) {

        cliente cliente1 = new cliente();
        cliente1.setNome();
        cliente1.setCpf();


        contato contato1 = new contato();
        contato1.setDescricao();
        contato1.setTelefone();
        contato1.setTipo();

        enderecos endereco1 = new enderecos();
        endereco1.setTipo(2);
        endereco1.setCep("42140705");
        endereco1.setCidade("SALVADOR");
        endereco1.setComplemento("casa");
        endereco1.setEstado("BA");
        endereco1.setLogradouro("RUA JOSE BONIFACIO");
        endereco1.setNumero(11);
        endereco1.setPais("Brasil");

        enderecos endereco2 = new enderecos();
        endereco2.setTipo(1);
        endereco2.setCep("42140705");
        endereco2.setLogradouro("Rua JULIO CESAR");
        endereco2.setNumero(17);
        endereco2.setComplemento("casa");
        endereco2.setCidade("SALVADOR");
        endereco2.setEstado("BA");
        endereco2.setPais("Brasil");

        contacorrente cc = new contacorrente();
        cc.setAgencia();
        cc.setNumeroconta();
        cc.setSaldo();
        cc.setChequeespecial(500.00);

        contapoupanca cp = new contapoupanca();
        cp.setNumeroconta();
        cp.setCliente();
        cp.setSaldo();
        cp.setAgencia();


    }
}

