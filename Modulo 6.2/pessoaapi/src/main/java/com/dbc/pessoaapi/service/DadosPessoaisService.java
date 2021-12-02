package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService {
    private final DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDTO> list(){
        return dadosPessoaisClient.list();
    }

    public DadosPessoaisDTO getByCpf(String cpf){
        return dadosPessoaisClient.getPorCpf(cpf);
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO){
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO update(String cpf, DadosPessoaisDTO dadosPessoaisDTO){
        return dadosPessoaisClient.update(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf) {
        dadosPessoaisClient.delete(cpf);
    }

}
