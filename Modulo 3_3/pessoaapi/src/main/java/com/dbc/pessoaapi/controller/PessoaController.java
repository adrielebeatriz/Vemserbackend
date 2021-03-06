package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoPessoaDTO;
import com.dbc.pessoaapi.dto.PessoaEnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EnderecoService;
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
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;

    @ApiOperation(value = "Cria uma nova pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Não foi possível criar esse registro"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaDTO pessoaEntityCriado = pessoaService.create(pessoaCreateDTO);
        return pessoaEntityCriado;
    }

    @ApiOperation(value = "Lista pessoa e dados pessoais por ID")
    @GetMapping("/{idPessoa}")
    public PessoaDTO getById(@RequestParam("idPessoa") Integer idPessoa) throws Exception {
        return pessoaService.getById(idPessoa);
    }

    @ApiOperation(value = "Lista todos os registros de pessoa e seus dados pessoais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiOperation(value = "Altera dados do cadastro da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa alterada com sucesso"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("Iniciando atualização de pessoa");
        PessoaDTO pessoaAtualizada = pessoaService.update(id, pessoaCreateDTO);
        log.info("Pessoa atualizada com sucesso");
        return pessoaAtualizada;
    }

    @ApiOperation(value = "Deleta cadastro de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa deletada com sucesso"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/find-by-nome-containing")
    public List<PessoaEntity> findByNomeContainingIgnoreCase(@RequestParam String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/find-by-cpf")
    public PessoaEntity findByCpf(@RequestParam String cpf) {
        return (PessoaEntity) pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/find-by-data-de-nascimento")
    public List<PessoaEntity> findByDataNascimentoBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return pessoaRepository.findByDataNascimentoBetween(inicio, fim);

    }

    @GetMapping("/pessoa-completo")
    public List<PessoaEntity> getAll(@RequestParam Integer id) {
        return pessoaRepository.findAll();
    }

    @GetMapping("/lista-by-contato")
    public List<ContatoPessoaDTO> getByContato() {
        return pessoaService.getByContato();
    }

    @GetMapping("/lista-by-endereco")
    public List<PessoaEnderecoDTO> getByEndereco() {
        return pessoaService.getByEndereco();
    }
    @GetMapping("/pessoa-contato")
    public List<ContatoPessoaDTO>listarPessoaComContatos(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa == null) {
            return pessoaService.listarContatoPessoaDTO(idPessoa);
        }
        return pessoaService.listarContatoPessoaDTO(idPessoa);
    }
    @GetMapping("/pessoa-endereco")
    public List<PessoaEnderecoDTO>listarPessoaComEnderecos(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa == null) {
            return pessoaService.listarPessoaComEnderecos(idPessoa);
        }
        return pessoaService.listarPessoaComEnderecos(idPessoa);
    }
    @GetMapping("/pessoa-com-endereco")
    public List<PessoaEntity> EnderecoPessoa() {
        return pessoaRepository.EnderecoPessoa();
    }

    @GetMapping("/pessoa-sem-endereco")
    public List<PessoaEntity> pessoaSemEndereco() {
        return pessoaRepository.pessoaSemEndereco();
    }
    @GetMapping("/pessoa-sem-endereco-query-nativa")
    public List<PessoaEntity> pessoaSemEnderecos(){
        return pessoaRepository.pessoaSemEndereco();
    }

    @GetMapping("/pessoa-contato2")
    public List<ContatoPessoaDTO>listaContatoPessoaDTO(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa == null) {
            return pessoaService.listarContatoPessoaDTO(idPessoa);
        }
        return pessoaService.listarContatoPessoaDTO(idPessoa);
    }
    @GetMapping("/pessoa-que-possuem-endereco")
    public List<PessoaEntity> pessoaQuePossuiEndereco() {
        return pessoaRepository.pessoaQuePossuemEndereco();
    }

    @GetMapping("/pessoa-por-dataDeNascimento")
    public List<PessoaEntity> PessoaPorDataNasci(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateInicial,
                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFinal) {
        return pessoaRepository.pessoaPorDataNasc(dateInicial,dateFinal);
    }
}