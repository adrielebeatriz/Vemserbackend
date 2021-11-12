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

    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;

    @GetMapping("/listar-by-descricao")
    public Page<ContatoEntity> listaPaginadaOrdenada(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina,
                Sort.by("descricao")
        );
        Page<ContatoEntity> paginaDoBanco = contatoRepository.findAll( pageable);
        return paginaDoBanco;
    }

    @GetMapping("/listar-endereco-order-by-cep")
    public Page<EnderecoEntity> enderecoByCep(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina,
                Sort.by("cep")
        );
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findAll( pageable);
        return paginaDoBanco;
    }

    @GetMapping("/lista-por-pais-jpql")
    public Page<EnderecoEntity> findByPaisPQL(
            @RequestParam String pais,
            @RequestParam Integer pagina,
            @RequestParam(defaultValue = "2", required = false) Integer quantidadeDeRegistrosPorPagina) {
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina);
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findByPaisPQL("%" + pais + "%", pageable);
        return paginaDoBanco;
    }
}