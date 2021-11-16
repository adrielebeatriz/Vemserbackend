package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContatoPessoaDTO {
    private Integer idPessoa;

    @NotNull
    @NotBlank
    @ApiModelProperty
    private String nome;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "Email da pessoa")
    private String email;

    @NotNull
    @Past()
    @ApiModelProperty(value = "Data da pessoa")
    private LocalDate dataNascimento;

    @NotNull
    @NotEmpty
    @Size(max = 11, min = 11)
    @ApiModelProperty(value = "Cpf da pessoa")
    private String cpf;

    private List<ContatoDTO> Contato;


}
