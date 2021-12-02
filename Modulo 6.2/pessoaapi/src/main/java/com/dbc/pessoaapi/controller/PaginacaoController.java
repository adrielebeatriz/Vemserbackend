package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;

import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contatos-ordenados-descricao")
    public Page<ContatoEntity> contatosOrderDescricao(
            @RequestParam Integer pagina,
            @RequestParam Integer qtdRegPagina){
        Pageable pageable = PageRequest.of(pagina, qtdRegPagina, Sort.by("descricao"));
        Page<ContatoEntity> paginaBanco = contatoRepository.findAll(pageable);
        return paginaBanco;
    }

    @GetMapping("/enderecos-ordenados-cep")
    public Page<EnderecoEntity> enderecoOrderCep(@RequestParam Integer pagina,
                                                       @RequestParam Integer qtdRegPagina){
        Pageable pageable = PageRequest.of(pagina, qtdRegPagina, Sort.by("cep"));
        Page<EnderecoEntity> paginaBanco = enderecoRepository.findAll(pageable);
        return paginaBanco;
    }

    @GetMapping("/enderecos-filtrados-pais")
    public Page<EnderecoEntity> enderecoFilterPais(
            @RequestParam String pais,
            @RequestParam Integer pagina,
                                                 @RequestParam Integer qtdRegPagina){
        Pageable pageable = PageRequest.of(pagina, qtdRegPagina);
        Page<EnderecoEntity> paginaBanco = enderecoRepository.findByPais(pais,pageable);
        return paginaBanco;
    }


}
