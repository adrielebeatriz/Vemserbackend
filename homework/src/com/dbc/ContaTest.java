package com.dbc;

import org.junit.Test;

import static junit.framework.TestCase.*;

    public class ContaTest {
        @Test
        public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
            ContaCorrente contaCorrenteClienteUm = new ContaCorrente();
            contaCorrenteClienteUm.setSaldo(1000);
            contaCorrenteClienteUm.setChequeEspecial(1000);
            boolean sacar = contaCorrenteClienteUm.sacar(150);
            double saldo = contaCorrenteClienteUm.getSaldo();
            assertTrue(sacar);
            assertEquals(850, saldo, 0);
        }

        @Test
        public void deveTestarSaqueContaCorrenteSemSaldo(){
            ContaCorrente contaCorrenteClienteUm = new ContaCorrente();
            contaCorrenteClienteUm.setSaldo(1000);
            contaCorrenteClienteUm.setChequeEspecial(1000);
            boolean sacar = contaCorrenteClienteUm.sacar(2500);
            double saldo = contaCorrenteClienteUm.getSaldo();
            assertFalse(sacar);
            assertEquals(1000, saldo,0);
        }

        @Test
        public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
            ContaPoupanca contaPoupancaClienteUm = new ContaPoupanca();
            contaPoupancaClienteUm.setSaldo(2000);
            contaPoupancaClienteUm.creditarTaxa();
            boolean sacar = contaPoupancaClienteUm.sacar(1000);
            double saldo = contaPoupancaClienteUm.getSaldo();
            assertTrue(sacar);
            assertEquals(1020,saldo,0);
        }
        @Test
        public void deveTestarSaqueContaPoupancaSemSaldo(){
            ContaPoupanca contaPoupancaClienteUm = new ContaPoupanca();
            contaPoupancaClienteUm.setSaldo(1000);
            contaPoupancaClienteUm.creditarTaxa();
            boolean sacar = contaPoupancaClienteUm.sacar(2000);
            double saldo = contaPoupancaClienteUm.getSaldo();
            assertFalse(sacar);
            assertEquals(1010, saldo,0);

        }
        @Test
        public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
            ContaPagamento contaPagamentoClienteUm = new ContaPagamento();
            contaPagamentoClienteUm.setSaldo(1000);
            boolean sacar = contaPagamentoClienteUm.sacar(500);
            double saldo = contaPagamentoClienteUm.getSaldo();
            assertTrue(sacar);
            assertEquals(495.75 ,saldo,0);
        }
        @Test
        public void deveTestarSaqueContaPagamentoSemSaldo(){
            //setup
            ContaPagamento contaPagamentoClienteUm = new ContaPagamento();
            contaPagamentoClienteUm.setSaldo(1000);
            //act
            boolean sacar = contaPagamentoClienteUm.sacar(1500);
            double saldo = contaPagamentoClienteUm.getSaldo();
            //assert
            assertFalse(sacar);
            assertEquals(1000,saldo,0);

        }
        @Test
        public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
            ContaCorrente contaCorrenteClienteUm = new ContaCorrente();
            contaCorrenteClienteUm.setSaldo(1000);
            ContaPoupanca contaPoupancaClienteDois = new ContaPoupanca();
            contaPoupancaClienteDois.setSaldo(2000);
            boolean transferir = contaCorrenteClienteUm.transferir(contaPoupancaClienteDois,500);
            double saldo1 = contaCorrenteClienteUm.getSaldo();
            double saldo2 = contaPoupancaClienteDois.getSaldo();
            assertTrue(transferir);
            assertEquals(500,saldo1,0);
            assertEquals(2500,saldo2,0);
        }
        @Test
        public void deveTestarTransferenciaSemSaldo(){

            ContaCorrente contaCorrenteClienteUm = new ContaCorrente();
            contaCorrenteClienteUm.setSaldo(1000);
            ContaPoupanca contaPoupancaClienteDois = new ContaPoupanca();
            contaPoupancaClienteDois.setSaldo(2000);
            boolean transferir = contaCorrenteClienteUm.transferir(contaPoupancaClienteDois,1500);
            double saldo1 = contaCorrenteClienteUm.getSaldo();
            double saldo2 = contaPoupancaClienteDois.getSaldo();
            assertFalse(transferir);
            assertEquals(1000,saldo1,0);
            assertEquals(2000,saldo2,0);

        }
        @Test
        public void deveTestarDepositoEVerificarSaldoComSucesso(){
            ContaPoupanca contaPoupancaClienteUm = new ContaPoupanca();
            contaPoupancaClienteUm.setSaldo(1000);
            boolean depositar = contaPoupancaClienteUm.depositar(1000);
            double saldo = contaPoupancaClienteUm.getSaldo();
            assertTrue(depositar);
            assertEquals(2000, saldo , 0);
        }
        @Test
        public void deveTestarDepositoNegativo(){
            ContaPoupanca contaPoupancaClienteUm = new ContaPoupanca();
            contaPoupancaClienteUm.setSaldo(1000);

            boolean depositar = contaPoupancaClienteUm.depositar(-1000);
            double saldo = contaPoupancaClienteUm.getSaldo();

            assertFalse(depositar);
            assertEquals(1000,saldo,0);



        }

    }


