package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.PK.ProfessorPk;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProfessorCreateDTO {

    @EmbeddedId
    private ProfessorPk professorPk;


    @Column(name = "id_professor")
    private Integer idProfessor;
    @Column(name = "id_universidade")
    private  Integer idUniversidade;
    @NotEmpty
    @NotBlank
    @Column(name = "nome")
    private  String nome;
    @NotNull
    @NotBlank
    @Column(name = "salario")
    private Double salario;
}
