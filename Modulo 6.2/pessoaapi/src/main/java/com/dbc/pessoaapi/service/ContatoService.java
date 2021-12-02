package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contaCriadaEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contaCriadaEntity.setPessoaEntity(pessoaEntity);
        ContatoEntity atualizado = contatoRepository.save(contaCriadaEntity);
        ContatoDTO dto = objectMapper.convertValue(atualizado, ContatoDTO.class);
        return null;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.findAll().stream()
                .map(x -> objectMapper.convertValue(x, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws Exception {
        ContatoDTO contato = findById(id);
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        entity.setIdContato(id);
        ContatoEntity atualizado = contatoRepository.save(entity);
        ContatoDTO dto = objectMapper.convertValue(atualizado, ContatoDTO.class);
        return dto;
    }

    public void delete(Integer id) throws Exception {
        ContatoDTO dto = findById(id);
        ContatoEntity entity = objectMapper.convertValue(dto, ContatoEntity.class);
        contatoRepository.delete(entity);
    }



    private ContatoDTO findById(Integer id) throws RegraDeNegocioException{
        ContatoEntity entity = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encotnrado"));

        ContatoDTO dto = objectMapper.convertValue(entity, ContatoDTO.class);
        return dto;
    }

}
