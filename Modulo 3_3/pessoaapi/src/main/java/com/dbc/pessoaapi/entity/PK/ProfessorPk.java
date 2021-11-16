package com.dbc.pessoaapi.entity.PK;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorPk implements Serializable {

    @Column(name = "id_professor")
    private Integer idProfessor;
    @Column(name = "id_universidade")
    private  Integer idUniversidade;
}
