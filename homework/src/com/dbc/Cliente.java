package com.dbc;



    public class Cliente {
        private String nome;
        private String cpf;
        private Contato[] contatos = new Contato[2];
        private Endereco[] enderecos = new Endereco[2];


        public void imprimirCliente() {
            System.out.println("Nome: " + this.getNome());
            System.out.println("CPF: " + this.getCpf());
            imprimirContatos();
            imprimirEnderecos();
        }

        public void imprimirContatos() {
            for (Contato contato : contatos) {
                if (contato != null) {
                    contato.imprimirContato();
                }
            }
        }

        public void imprimirEnderecos() {
            for (Endereco endereco : enderecos) {
                if (endereco != null) {
                    endereco.imprimirEndereco();
                }
            }
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public Contato[] getContatos() {
            return contatos;
        }

        public void setContatos(Contato[] contatos) {
            this.contatos = contatos;
        }

        public Endereco[] getEnderecos() {
            return enderecos;
        }

        public void setEnderecos(Endereco[] enderecos) {
            this.enderecos = enderecos;
        }
    }

