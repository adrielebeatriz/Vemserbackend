package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {
    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public List<DadosPessoaisDTO> list(){
        return dadosPessoaisService.list();
    }

    @GetMapping("/bycpf")
    public DadosPessoaisDTO listByCpf(@RequestParam("cpf") String cpf){
        return dadosPessoaisService.getByCpf(cpf);
    }
    @PostMapping
    public DadosPessoaisDTO create(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO){
        return dadosPessoaisService.create(dadosPessoaisDTO);
    }

    @PutMapping("/{atualizacpf}")
    public DadosPessoaisDTO update(@Valid @PathVariable("atualizacpf") String cpf,
                            @Valid @RequestBody DadosPessoaisDTO pessoaCreateDTO) throws Exception {
        return dadosPessoaisService.update(cpf, pessoaCreateDTO);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) throws Exception{
        dadosPessoaisService.delete(cpf);
    }

}
