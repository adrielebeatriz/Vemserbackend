package com.dbc;


public class Main {
    public static void main(String[] args) {
        Contato clienteC1 = new Contato();
        clienteC1.setDescricao("whats");
        clienteC1.setTelefone("12981117598");
        clienteC1.setTipo(1);

        Contato cliente1C2 = new Contato();
        cliente1C2.setDescricao("whats");
        cliente1C2.setTelefone("12997059031");
        cliente1C2.setTipo(2);

        Endereco clienteUmEnd1 = new Endereco();
        clienteUmEnd1.setTipo(1);
        clienteUmEnd1.setLogradouro("julio cesar");
        clienteUmEnd1.setNumero(484);
        clienteUmEnd1.setComplemento("Nenhum");
        clienteUmEnd1.setCep("41705140");
        clienteUmEnd1.setCidade("simões Filho");
        clienteUmEnd1.setEstado("Bahia");
        clienteUmEnd1.setPais("Brasil");

        Endereco cliente1E2 = new Endereco();
        cliente1E2.setTipo(2);
        cliente1E2.setLogradouro("Rua do campo largo");
        cliente1E2.setNumero(584);
        cliente1E2.setComplemento("Nenhum");
        cliente1E2.setCep("41205-020");
        cliente1E2.setCidade("Salvador");
        cliente1E2.setEstado("Bahia");
        cliente1E2.setPais("Brasil");

        Cliente clienteUm = new Cliente();
        clienteUm.setNome("Daniel");
        clienteUm.setCpf("07507248186");
        clienteUm.getEnderecos ()[0]= new Endereco();
        clienteUm.getEnderecos ()[1]= new Endereco();
        clienteUm.getContatos()[0] = new Contato();
        clienteUm.getContatos()[1] = new Contato();

        ContaPagamento contaPagamentoClienteUm = new ContaPagamento();
        contaPagamentoClienteUm.setCliente(clienteUm);
        contaPagamentoClienteUm.setSaldo(5000);
        contaPagamentoClienteUm.setNumeroConta("250");
        contaPagamentoClienteUm.setAgencia("001");

        ContaCorrente contaCorrenteClienteUm = new ContaCorrente();
        contaCorrenteClienteUm.setCliente(clienteUm);
        contaCorrenteClienteUm.setNumeroConta("504");
        contaCorrenteClienteUm.setSaldo(5000);
        contaCorrenteClienteUm.setAgencia("804");
        contaCorrenteClienteUm.setChequeEspecial(5000);





        Contato cliente2C1 = new Contato();
        cliente2C1.setDescricao("celular");
        cliente2C1.setTelefone("1298880000");
        cliente2C1.setTipo(1);

        Contato cliente2C2 = new Contato();
        cliente2C2.setDescricao("fixo");
        cliente2C2.setTelefone("7132577318");
        cliente2C2.setTipo(2);

        Endereco clienteDoisEndereco1 = new Endereco();
        clienteDoisEndereco1.setTipo(1);
        clienteDoisEndereco1.setLogradouro("rua do sossego");
        clienteDoisEndereco1.setNumero(684);
        clienteDoisEndereco1.setComplemento("fundo");
        clienteDoisEndereco1.setCep("41205-010");
        clienteDoisEndereco1.setCidade("Salvador");
        clienteDoisEndereco1.setEstado("Bahia");
        clienteDoisEndereco1.setPais("Brasil");

        Endereco clienteDoisEndereco2 = new Endereco();
        clienteDoisEndereco2.setTipo(2);
        clienteDoisEndereco2.setLogradouro("rua das Palmeiras");
        clienteDoisEndereco2.setNumero(784);
        clienteDoisEndereco2.setComplemento("1° andar");
        clienteDoisEndereco2.setCep("41205-015");
        clienteDoisEndereco2.setCidade("Salvdor");
        clienteDoisEndereco2.setEstado("Bahia");
        clienteDoisEndereco2.setPais("Brasil");

        Cliente clienteDois = new Cliente();
        clienteDois.setNome("Denise");
        clienteDois.setCpf("10227477472");
        clienteDois.getEnderecos ()[0]= new Endereco();
        clienteDois.getEnderecos ()[1]= new Endereco();
        clienteDois.getContatos()[0] = new Contato();
        clienteDois.getContatos()[1] = new Contato();

        ContaPoupanca contaPoupancaClienteDois = new ContaPoupanca();
        contaPoupancaClienteDois.setSaldo(5000);
        contaPoupancaClienteDois.setCliente(clienteDois);
        contaPoupancaClienteDois.setNumeroConta("505");
        contaPoupancaClienteDois.setAgencia("325");


        contaCorrenteClienteUm.transferir(contaPoupancaClienteDois,500);


        contaPagamentoClienteUm.sacar(250);



        contaPoupancaClienteDois.depositar(1000);

        contaPagamentoClienteUm.imprimir();
        contaCorrenteClienteUm.imprimir();
        contaPoupancaClienteDois.imprimir();


    }
}