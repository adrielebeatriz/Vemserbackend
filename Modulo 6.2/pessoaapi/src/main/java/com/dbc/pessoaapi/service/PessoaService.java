package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;


    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaCreateDTO) throws Exception {
        findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        entity.setIdPessoa(id);
        PessoaEntity atualizado = pessoaRepository.save(entity);
        PessoaDTO dto = objectMapper.convertValue(atualizado, PessoaDTO.class);
        return dto;
    }

    public PessoaDTO findById(Integer id) throws RegraDeNegocioException{
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public void delete(Integer id) throws Exception {
        PessoaDTO pessoaDeletada = findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaDeletada, PessoaEntity.class);
        pessoaRepository.delete(entity);

    }

    public List<PessoaContatoDTO> getByContato(){
        return pessoaRepository.findAll().stream()
                .map(x -> {
                    PessoaContatoDTO pessoaContatoDTO = objectMapper.convertValue(x, PessoaContatoDTO.class);
                    pessoaContatoDTO.setListaContato(x.getContatos().stream()
                            .map(contato -> {
                                ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                return contatoDTO;
                            })
                            .collect(Collectors.toList()));
                    return pessoaContatoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PessoaEnderecoDTO> getByEndereco(){
        return pessoaRepository.findAll().stream()
                .map(x -> {
                    PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(x, PessoaEnderecoDTO.class);
                    pessoaEnderecoDTO.setListaDeEnderecos(x.getEnderecos().stream()
                            .map(endereco -> {
                                EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                                return enderecoDTO;
                            })
                            .collect(Collectors.toList()));
                    return pessoaEnderecoDTO;
                })
                .collect(Collectors.toList());
    }


    public PessoaDTO listById(Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public List<PessoaContatoDTO> pessoasComContato(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaContatoDTO> listaContatos = new ArrayList<>();
        if (idPessoa != null) {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).orElseThrow(()-> new RegraDeNegocioException("ERRO !! Pessoa não encontrada"));
            PessoaContatoDTO pessoaContatoDTO = objectMapper.convertValue(pessoaEntity,PessoaContatoDTO.class);
            pessoaContatoDTO.setListaContato(pessoaEntity.getContatos().stream()
                    .map(contato -> {
                        ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                        contatoDTO.setIdPessoa(idPessoa);
                        return contatoDTO;
                    })
                    .collect(Collectors.toList()));
            listaContatos.add(pessoaContatoDTO);
            return listaContatos;

        }else {
            return pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaContatoDTO pessoaContatoDTO = objectMapper.convertValue(pessoa, PessoaContatoDTO.class);
                        pessoaContatoDTO.setListaContato(pessoa.getContatos().stream()
                                .map(contato -> {
                                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                    return contatoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaContatoDTO;
                    })
                    .collect(Collectors.toList());
        }

    }

    public List<PessoaEnderecoDTO> pessoasComEndereco(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaEnderecoDTO> listaEnderecos = new ArrayList<>();
        if (idPessoa != null) {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoaEntity,PessoaEnderecoDTO.class);
            pessoaEnderecoDTO.setListaDeEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> {
                        EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                        enderecoDTO.setIdPessoa(idPessoa);
                        return enderecoDTO;
                    })
                    .collect(Collectors.toList()));
            listaEnderecos.add(pessoaEnderecoDTO);
            return listaEnderecos;
        }else {
            return pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoa, PessoaEnderecoDTO.class);
                        pessoaEnderecoDTO.setListaDeEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> {
                                    EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                                    return enderecoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaEnderecoDTO;
                    })

                    .collect(Collectors.toList());
        }
    }

}
