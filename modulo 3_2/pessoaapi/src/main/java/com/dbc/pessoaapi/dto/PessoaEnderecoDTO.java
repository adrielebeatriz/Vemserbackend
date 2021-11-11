package com.dbc.pessoaapi.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PessoaEnderecoDTO extends PessoaDTO{
    List<EnderecoDTO> enderecoDTOS;
}
