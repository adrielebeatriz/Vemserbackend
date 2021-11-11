package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    PessoaEntity findByCpf(String nome);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);

    @Query("select p from PESSOA p " +
            "left join p.enderecos e")
    List<PessoaEntity> EnderecoPessoa();


}
