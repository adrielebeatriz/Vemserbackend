package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PK.ProfessorPk;
import com.dbc.pessoaapi.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository  extends JpaRepository<ProfessorEntity, ProfessorPk>{
}
