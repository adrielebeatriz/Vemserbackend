package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {

        EnderecoEntity enderecoNew = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoRepository.save(enderecoNew);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoNew, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    private EnderecoEntity findById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoentity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoentity;
    }

    public EnderecoDTO getById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoentity = findById(id);
        EnderecoDTO dto = objectMapper.convertValue(enderecoentity, EnderecoDTO.class);
        return dto;
    }
    public EnderecoDTO update(Integer idEndereco,
                                 EnderecoCreateDTO enderecoAtualizar) throws Exception {

        findById(idEndereco);
        EnderecoEntity endereco = objectMapper.convertValue(enderecoAtualizar,EnderecoEntity.class);
        endereco.setIdEndereco(idEndereco);
        EnderecoEntity enderecoupdate = enderecoRepository.save(endereco);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoupdate, EnderecoDTO.class);
        return enderecoDTO;

    }

    public void delete(Integer id) throws Exception {
        EnderecoEntity endereco = findById(id);
        enderecoRepository.delete(endereco);
    }


}
