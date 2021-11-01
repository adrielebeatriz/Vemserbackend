package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.DTO.PessoaCreateDTO;
import com.dbc.pessoaapi.DTO.PessoaDTO;

import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor

public class PessoaController {


    private  final PessoaService pessoaService;



    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaDTO) throws Exception {
        log.info("iniciando criação da pessoa");
        PessoaDTO pessoaEntityCriado = pessoaService.create(pessoaDTO);
        log.info("pessoa criada com sucesso!");
        return pessoaEntityCriado;
    }

    @GetMapping
    public List<PessoaDTO> list() {

        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") @NotEmpty(message = "nome da pessoa não informado") String nome) {
        return pessoaService.listByName(nome);
    }




    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        return pessoaService.update(id, pessoaCreateDTO);
    }
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa")  @Valid Integer idPessoa) throws Exception {
        log.info("deletando pessoa");
        pessoaService.delete(idPessoa);
        log.info("pessoa deletada com sucesso");

}
}