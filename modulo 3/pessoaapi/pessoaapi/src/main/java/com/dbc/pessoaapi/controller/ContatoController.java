package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController

@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @PostMapping ("/{idPessoa}")
    public Contato create(@PathVariable ("idPessoa") Integer id,  @RequestBody Contato contato) throws RegraDeNegocioException {
        return contatoService.create(id,contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/byidpessoa")
    public List<Contato> listByIdPessoa(  @PathVariable("idPessoa") Integer id) {
        return contatoService.listByIdPessoa(id);
    }


    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete( @PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
    }

