package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
@RequiredArgsConstructor
public class EnderecoController {
    private final EnderecoService enderecoService;
    private final EnderecoRepository enderecoRepository;

    @ApiOperation(value = "Lista todos os endereços cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listagem de endereços"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    public List<EnderecoDTO> list(){return enderecoService.list();}

    @ApiOperation(value = "Lista endereço por ID do endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço encontrado"),
            @ApiResponse(code = 400, message = "Endereço não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    public EnderecoDTO listByEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.listByEndereco(idEndereco);
    }

    @ApiOperation(value = "Altera informações de um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço alterado com sucesso"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    public EnderecoDTO update(@Valid @PathVariable("idEndereco") Integer id,
                              @Valid @RequestBody EnderecoCreateDTO enderecoCreateDTO)
            throws Exception {
        log.info("Atualizando pessoa");
        EnderecoDTO enderecoDTO = enderecoService.update(id, enderecoCreateDTO);
        log.info("Atualizado com sucesso");
        return enderecoDTO;
    }

    @ApiOperation(value = "Cria uma novo endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    public EnderecoDTO create(@Valid @RequestBody EnderecoCreateDTO enderecoCreateDTO)
            throws RegraDeNegocioException {
        log.info("Criando pessoa");
        EnderecoDTO enderecoDTO = enderecoService.create(enderecoCreateDTO);
        log.info("Criado com sucesso");
        return enderecoDTO;
    }

    @ApiOperation(value = "Deleta endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço deletado com sucesso"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        log.info("Deletando pessoa");
        enderecoService.delete(id);
        log.info("Deletado com sucesso");
    }
    @GetMapping("/procura-por-pais")
    public List<EnderecoEntity> enderecoByCountry(@RequestParam String pais) {
        return enderecoRepository.enderecoByCountry(pais.toUpperCase());
    }


    @GetMapping("/endereco-por-pessoa")
    public List<EnderecoEntity> endercoByPerson(@RequestParam("idPessoa") Integer idPessoa){
        return enderecoRepository.endercoByPerson(idPessoa);
    }

    @GetMapping("/endereco-cidade-pais")
    public List<EnderecoEntity> enderecoCountryCity(@RequestParam("pais") String pais,@RequestParam("cidade") String cidade){
        return enderecoRepository.enderecoCountryCity(pais, cidade);
    }
    }
