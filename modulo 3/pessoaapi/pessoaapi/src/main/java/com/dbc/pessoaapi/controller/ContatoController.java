package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.DTO.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @PostMapping ("/{idPessoa}")
    public ContatoDTO create(@PathVariable ("idPessoa") Integer id, @RequestBody ContatoEntity contatoEntity) throws Exception {
       log.info("Contato criado");
        ContatoDTO contatonew = contatoService.create(id, contatoEntity);
        log.info("Contatao criado com sucesso");
        return contatonew;
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @GetMapping("/byidpessoa")
    public List<ContatoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return contatoService.listPorIdPessoa(id);
    }


    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer id,
                             @RequestBody ContatoEntity contatoEntityAtualizar) throws Exception {
        log.info("Contato Atualizado");
        ContatoDTO contatonew = contatoService.create(id, contatoEntityAtualizar);
        log.info("Contato atualizado com sucesso");
        return contatonew;
    }

    @DeleteMapping("/{idContato}")
    public void delete( @PathVariable("idContato") Integer id) throws Exception {
        log.info("contato será deletado");
        contatoService.delete(id);
        log.info("Contato deletado com sucesso");
    }
    }

