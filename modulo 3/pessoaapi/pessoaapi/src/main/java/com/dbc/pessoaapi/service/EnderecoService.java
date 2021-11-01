package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<EnderecoEntity> list() {
        return enderecoRepository.list();
    }
    public List<EnderecoEntity> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public EnderecoEntity create(Integer idPessoa, EnderecoEntity enderecoEntity) throws RegraDeNegocioException {
        pessoaRepository.getIdById(idPessoa);
        enderecoEntity.setIdPessoa(idPessoa);
        return enderecoRepository.create(enderecoEntity);
    }

    public EnderecoEntity update(Integer idEndereco, EnderecoEntity enderecoEntityAtual) throws Exception {
        return enderecoRepository.update(idEndereco, enderecoEntityAtual);
    }

    public void delete(Integer idEndereco) throws Exception {
        enderecoRepository.delete(idEndereco);
    }
}