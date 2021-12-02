package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity entity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity atualizado = enderecoRepository.save(entity);
        EnderecoDTO dto = objectMapper.convertValue(atualizado, EnderecoDTO.class);
        return dto;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll().stream()
                .map(x -> objectMapper.convertValue(x, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listByEndereco(Integer id) throws Exception{
        EnderecoEntity entity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        EnderecoDTO dto = objectMapper.convertValue(entity, EnderecoDTO.class);
        return dto;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws Exception{
        findById(idEndereco);
        EnderecoEntity entity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        entity.setIdEndereco(idEndereco);
        EnderecoEntity update = enderecoRepository.save(entity);
        EnderecoDTO dto = objectMapper.convertValue(update, EnderecoDTO.class);
        return dto;
    }

    private EnderecoDTO findById(Integer id) throws RegraDeNegocioException{
        EnderecoEntity entity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        EnderecoDTO dto = objectMapper.convertValue(entity, EnderecoDTO.class);
        return dto;
    }

    public void delete(Integer id) throws Exception {
        EnderecoDTO dto = findById(id);
        EnderecoEntity entity = objectMapper.convertValue(dto, EnderecoEntity.class);
        enderecoRepository.delete(entity);
    }

}
