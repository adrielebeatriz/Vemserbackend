package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    @NotNull
    @Max(1)
    @Min(0)
    @ApiModelProperty(value = "Tipo de contato")
    private Integer tipoContato;

    @NotNull
    @Size(max = 13)
    @ApiModelProperty(value = "Numero contato")
    private String numero;

    @Size(max = 110)
    @ApiModelProperty(value = "Descrição contato")
    private String descricao;

}