package com.dbc.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EmailDTO {

//    @NotNull(message = "não pode ser null")
//    @NotEmpty(message = "não pode ser vazio")
    private String destinatario;

    @NotNull(message = "não pode ser null")
    @NotEmpty(message = "não pode ser vazio")
    private String assunto;

    @NotNull(message = "não pode ser null")
    @NotEmpty(message = "não pode ser vazio")
    @Size(max = 100)
    private String texto;
}
