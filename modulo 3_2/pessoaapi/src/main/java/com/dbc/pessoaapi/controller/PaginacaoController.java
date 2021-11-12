package com.dbc.pessoaapi.controller;

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

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public  class PaginacaoController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;
    @GetMapping("/contato-orderby-descricao")
    public Page<ContatoEntity> contatoOrdeByDescricao(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina, Sort.by("descricao"));
        Page<ContatoEntity> paginaDoBanco = contatoRepository.findAll(pageable);
        return paginaDoBanco;
    }

    @GetMapping("/lista-endereco-orderby-cep")
    public Page<EnderecoEntity> enderecoOrderBYCep(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina, Sort.by("cep"));
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findAll(pageable);
        return paginaDoBanco;
    }

    @GetMapping("/lista-endereco-pais")
    public Page<EnderecoEntity> enderecoByCountryPageable(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina,
            @RequestParam String pais)
    {
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina);
        Page<EnderecoEntity> paginaDoBanco = (Page<EnderecoEntity>) enderecoRepository.enderecoByCountry( pais, pageable);
        return paginaDoBanco;
    }

}