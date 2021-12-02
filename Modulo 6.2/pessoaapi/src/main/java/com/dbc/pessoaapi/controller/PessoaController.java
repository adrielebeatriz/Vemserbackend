package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaContatoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaEnderecoDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Validated
@RestController
@RequestMapping("/pessoa")
@Slf4j
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;


    @ApiOperation(value = "Cria uma pessoa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Pessoa criada"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um execeção")
    })
    @PostMapping
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws Exception{
        log.info("Criando pessoa");
        PessoaDTO pessoa = pessoaService.create(pessoaCreateDTO);
        log.info("Criado com sucesso");
        return pessoa;
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Pessoas da lista"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um execeção")
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiOperation(value = "Retornta lista de pessoas pelo id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Pessoas da lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um execeção")
    })
    @GetMapping("/byid")
    public PessoaDTO listById(@Valid @RequestParam("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listById(idPessoa);
    }

    @ApiOperation(value = "Atualiza lista de pessoas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizado com sucesso!"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um execeção")
    })
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@Valid @NotNull(message = "não pode ter id null") @PathVariable("idPessoa") Integer id,
                               @Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("Atualizando pessoa");
        PessoaDTO pessoaDTO = pessoaService.update(id, pessoaCreateDTO);
        log.info("Atualizado com sucesso");
        return pessoaDTO;
    }

    @ApiOperation(value = "Deletar pessoa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletado com sucesso!"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um execeção")
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando pessoa");
        pessoaService.delete(id);

        log.info("Deletado com sucesso");
    }

    @GetMapping("/get-by-nome")
    public List<PessoaEntity> findByNomeContainingIgnoreCase(@RequestParam("nome")
               String nome){
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/get-by-cpf")
    public PessoaEntity findByCpf(@RequestParam("cpf")
                                                                     String cpf){
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/find-by-data-nascimento")
    public List<PessoaEntity> pessoaPorDataNacismento(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim){

        return pessoaRepository.pessoaPorDataNacismento(dataInicio, dataFim);
    }

    @GetMapping("/lista-by-contato")
    public List<PessoaContatoDTO> getByContato(){
        return pessoaService.getByContato();
    }

    @GetMapping("/lista-by-endereco")
    public List<PessoaEnderecoDTO> getByEndereco(){return pessoaService.getByEndereco();}

    @GetMapping("/pessoa-com-endereco")
    public List<PessoaEntity> pessoaComEndereco(){
        return pessoaRepository.pessoaComEndereco();
    }

    @GetMapping("/pessoa-com-endereco-query-nativa")
    public List<PessoaEntity> pessoaSemEndereco(){
        return pessoaRepository.pessoaSemEndereco();
    }

    @GetMapping("/pessoas-com-contato")
    public List<PessoaContatoDTO> pessoasComContato (@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.pessoasComContato(idPessoa);
    }

    @GetMapping("/pessoas-com-endereco")
    public List<PessoaEnderecoDTO> pessoasComEndereco(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.pessoasComEndereco(idPessoa);
    }

}
