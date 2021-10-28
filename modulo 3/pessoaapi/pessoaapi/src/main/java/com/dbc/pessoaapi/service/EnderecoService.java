package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco create(Integer idPessoa, Endereco endereco) {
        return enderecoRepository.create(idPessoa, endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtual) throws Exception {
        return enderecoRepository.update(idEndereco, enderecoAtual);
    }

    public void delete(Integer idEndereco) throws Exception {
        enderecoRepository.delete(idEndereco);
    }
}
