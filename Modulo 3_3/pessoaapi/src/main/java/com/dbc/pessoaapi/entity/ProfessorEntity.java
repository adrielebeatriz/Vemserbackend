package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.entity.PK.ProfessorPk;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PROFESSOR")
public class ProfessorEntity {
    @EmbeddedId
    private ProfessorPk professorPk;

    @Column(name = "nome")
    private  String nome;
    @Column(name = "salario")
    private Double salario;
}
