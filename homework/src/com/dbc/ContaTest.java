package com.dbc;

import org.junit.Test;

import static junit.framework.TestCase.*;

    public class ContaTest {
        @Test
        public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
            ContaCorrente contaCorrenteC1 = new ContaCorrente();
            contaCorrenteC1.setSaldo(1000);
            contaCorrenteC1.setChequeEspecial(1000);
            boolean sacar = contaCorrenteC1.sacar(150);
            double saldo = contaCorrenteC1.getSaldo();
            assertTrue(sacar);
            assertEquals(850, saldo, 0);
        }

        @Test
        public void deveTestarSaqueContaCorrenteSemSaldo(){
            ContaCorrente contaCorrenteC1 = new ContaCorrente();
            contaCorrenteC1.setSaldo(1000);
            contaCorrenteC1.setChequeEspecial(1000);
            boolean sacar = contaCorrenteC1.sacar(2500);
            double saldo = contaCorrenteC1.getSaldo();
            assertFalse(sacar);
            assertEquals(1000, saldo,0);
        }

        @Test
        public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
            ContaPoupanca contaPoupancaC1 = new ContaPoupanca();
            contaPoupancaC1.setSaldo(2000);
            contaPoupancaC1.creditarTaxa();
            boolean sacar = contaPoupancaC1.sacar(1000);
            double saldo = contaPoupancaC1.getSaldo();
            assertTrue(sacar);
            assertEquals(1020,saldo,0);
        }
        @Test
        public void deveTestarSaqueContaPoupancaSemSaldo(){
            ContaPoupanca contaPoupancaC1 = new ContaPoupanca();
            contaPoupancaC1.setSaldo(1000);
            contaPoupancaC1.creditarTaxa();
            boolean sacar = contaPoupancaC1.sacar(2000);
            double saldo = contaPoupancaC1.getSaldo();
            assertFalse(sacar);
            assertEquals(1010, saldo,0);

        }
        @Test
        public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
            ContaPagamento contaPagamentoC1 = new ContaPagamento();
            contaPagamentoC1.setSaldo(1000);
            boolean sacar = contaPagamentoC1.sacar(500);
            double saldo = contaPagamentoC1.getSaldo();
            assertTrue(sacar);
            assertEquals(495.75 ,saldo,0);
        }
        @Test
        public void deveTestarSaqueContaPagamentoSemSaldo(){
            ContaPagamento contaPagamentoC1 = new ContaPagamento();
            contaPagamentoC1.setSaldo(1000);
            boolean sacar = contaPagamentoC1.sacar(1500);
            double saldo = contaPagamentoC1.getSaldo();
            assertFalse(sacar);
            assertEquals(1000,saldo,0);

        }
        @Test
        public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
            ContaCorrente contaCorrenteC1 = new ContaCorrente();
            contaCorrenteC1.setSaldo(1000);
            ContaPoupanca contaPoupancaC2 = new ContaPoupanca();
            contaPoupancaC2.setSaldo(2000);
            boolean transferir = contaCorrenteC1.transferir(contaPoupancaC2,500);
            double saldo1 = contaCorrenteC1.getSaldo();
            double saldo2 = contaPoupancaC2.getSaldo();
            assertTrue(transferir);
            assertEquals(500,saldo1,0);
            assertEquals(2500,saldo2,0);
        }
        @Test
        public void deveTestarTransferenciaSemSaldo(){

            ContaCorrente contaCorrenteC1 = new ContaCorrente();
            contaCorrenteC1.setSaldo(1000);
            ContaPoupanca contaPoupancaC2 = new ContaPoupanca();
            contaPoupancaC2.setSaldo(2000);
            boolean transferir = contaCorrenteC1.transferir(contaPoupancaC2,2500);
            double saldo1 = contaCorrenteC1.getSaldo();
            double saldo2 = contaPoupancaC2.getSaldo();
            assertFalse(transferir);
            assertEquals(1000,saldo1,0);
            assertEquals(2000,saldo2,0);

        }
        @Test
        public void deveTestarDepositoEVerificarSaldoComSucesso(){
            ContaPoupanca contaPoupancaC1 = new ContaPoupanca();
            contaPoupancaC1.setSaldo(1000);
            boolean depositar = contaPoupancaC1.depositar(1000);
            double saldo = contaPoupancaC1.getSaldo();
            assertTrue(depositar);
            assertEquals(2000, saldo , 0);
        }
        @Test
        public void deveTestarDepositoNegativo(){
            ContaPoupanca contaPoupancaC1 = new ContaPoupanca();
            contaPoupancaC1.setSaldo(1000);

            boolean depositar = contaPoupancaC1.depositar(-1000);
            double saldo = contaPoupancaC1.getSaldo();

            assertFalse(depositar);
            assertEquals(1000,saldo,0);



        }

    }


