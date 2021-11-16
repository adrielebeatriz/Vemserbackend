package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {

        PessoaEntity pessoaCriada = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoaRepository.save(pessoaCriada);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
    private PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
        return entity;
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public PessoaDTO update(Integer id,
                               PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        findById(id);
        PessoaEntity pessoa = objectMapper.convertValue(pessoaCreateDTO,PessoaEntity.class);
        pessoa.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
        return pessoaDTO;
    }



    public void delete(Integer id) throws Exception {

        PessoaEntity pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }


    public List<ContatoPessoaDTO> getByContato(){
        return pessoaRepository.findAll().stream()
                .map(x -> {
                    ContatoPessoaDTO contatoPessoaDTO = objectMapper.convertValue(x, ContatoPessoaDTO.class);
                    contatoPessoaDTO.setContato(x.getContatos().stream()
                            .map(contato -> {
                                ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                return contatoDTO;
                            })
                            .collect(Collectors.toList()));
                    return contatoPessoaDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PessoaEnderecoDTO> getByEndereco(){
        return pessoaRepository.findAll().stream()
                .map(x -> {
                    PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(x, PessoaEnderecoDTO.class);
                    pessoaEnderecoDTO.setEnderecoDTOS(x.getEnderecos().stream()
                            .map(endereco -> {
                                EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                                return enderecoDTO;
                            })
                            .collect(Collectors.toList()));
                    return pessoaEnderecoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<ContatoPessoaDTO> listarContatoPessoaDTO(Integer id) throws RegraDeNegocioException {
        List<ContatoPessoaDTO> listaPessoaContatoDTO = new ArrayList<>();
        if (id == null) {
            listaPessoaContatoDTO = pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        ContatoPessoaDTO pessoaContatoDTO = objectMapper.convertValue(pessoa, ContatoPessoaDTO.class);
                        pessoaContatoDTO.setContato(pessoa.getContatos().stream()
                                .map(contato -> {
                                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                    return contatoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaContatoDTO;
                    })
                    .collect(Collectors.toList());

            return listaPessoaContatoDTO;
        }
        PessoaEntity pessoa = findById(id);
        ContatoPessoaDTO pessoaContatoDTO = objectMapper.convertValue(pessoa, ContatoPessoaDTO.class);
        pessoaContatoDTO.setContato(pessoa.getContatos().stream()
                .map(contatoEntity -> {
                    ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity,ContatoDTO.class);
                    contatoDTO.setIdPessoa(id);
                    return contatoDTO;
                })
                .collect(Collectors.toList())
        );
        listaPessoaContatoDTO.add(pessoaContatoDTO);
        return listaPessoaContatoDTO;
    }

    public List<PessoaEnderecoDTO> listarPessoaComEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaEnderecoDTO> listaPessoaEnderecoDTO = new ArrayList<>();
        if (idPessoa == null) {
            listaPessoaEnderecoDTO = pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoaEntity, PessoaEnderecoDTO.class);
                        pessoaEnderecoDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> {
                                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                                    return enderecoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaEnderecoDTO;
                    })
                    .collect(Collectors.toList());
            return listaPessoaEnderecoDTO;
        }
        PessoaEntity pessoa = findById(idPessoa);
        PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoa,PessoaEnderecoDTO.class);
        pessoaEnderecoDTO.setEnderecoDTOS(pessoa.getEnderecos().stream()
                .map(enderecoEntity -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(idPessoa);
                    return enderecoDTO;
                })
                .collect(Collectors.toList()));
        listaPessoaEnderecoDTO.add(pessoaEnderecoDTO);
        return listaPessoaEnderecoDTO;
    }

}
