package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa create(Pessoa pessoa) throws Exception{
        if (StringUtils.isBlank(pessoa.getNome())){
            throw new Exception("NOME  NÃO INFORMADO");

        }
        if(ObjectUtils.isEmpty(pessoa.getDataNascimento())){
                throw  new Exception("Não pode inserir pessoa sem data de nascimento");
        }  if(StringUtils.isBlank(pessoa.getCpf())){
            throw new Exception("cpf não informada");
        } else if(pessoa.getCpf().length()!= 11){
            throw new Exception("CPF DEVE SER MAIOR OU IGUAL A 11");
        }
        return pessoaRepository.create(pessoa);



    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
         pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

}
