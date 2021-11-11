package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@RequiredArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;


    public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contoEntity.setPessoaEntity(pessoaEntity);
        ContatoEntity atualizado = contatoRepository.save(contoEntity);
        ContatoDTO dto = objectMapper.convertValue(atualizado, ContatoDTO.class);
        return null;
    }

    public List<ContatoDTO> list(){

        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());

    }
    private ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoentity = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoentity;
    }

    public ContatoDTO getById(Integer id) throws RegraDeNegocioException {
        ContatoEntity entity = findById(id);
        ContatoDTO dto = objectMapper.convertValue(entity, ContatoDTO.class);
        return dto;
    }

    public ContatoDTO update(Integer idContato,
                                ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {

        findById(idContato);
        ContatoEntity contato = objectMapper.convertValue(contatoCreateDTO,ContatoEntity.class);
        contato.setIdContato(idContato);
        ContatoEntity contatoupdate = contatoRepository.save(contato);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoupdate, ContatoDTO.class);

        return contatoDTO;

    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contato = findById(id);
        contatoRepository.delete(contato);
    }


}