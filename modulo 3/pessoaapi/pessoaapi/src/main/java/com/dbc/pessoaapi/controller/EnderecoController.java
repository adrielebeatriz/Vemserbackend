package com.dbc.pessoaapi.controller;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoEntity> list() {
        return enderecoService.list();
    }
    @GetMapping("/{idEndereco}")
    public List<EnderecoEntity> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoEntity> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoEntity create(@PathVariable ("idPessoa") Integer idPessoa,
                                 @Valid @RequestBody EnderecoEntity enderecoEntity) throws Exception {
        log.info("Endereço será criado");
        EnderecoEntity endereconew =  enderecoService.update(idPessoa, enderecoEntity);
        log.info("Endereço criado com sucesso");

        return endereconew;
    }


    @PutMapping("/{idEndereco}")
    public EnderecoEntity update(@PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoEntity enderecoEntityAtual) throws Exception {
        log.info("endereço está sendo atualizado");
        EnderecoEntity endereconew =  enderecoService.update(idEndereco, enderecoEntityAtual);
        log.info("Endereço atualizado com sucesso");

        return endereconew;
    }


    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        log.info("deletando endereco");
        enderecoService.delete(idEndereco);
        log.info("endereco deletada com sucesso");
    }

}
