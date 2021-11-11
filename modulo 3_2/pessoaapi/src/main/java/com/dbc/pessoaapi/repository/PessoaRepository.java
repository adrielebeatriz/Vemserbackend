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
            " join p.enderecos e")
    List<PessoaEntity> EnderecoPessoa();

    @Query("select p from Pessoa p where p.dataNascimento between :inicio and :fim")
    List<PessoaEntity> pessoaPorDataNasc(LocalDate inicio, LocalDate fim);

    @Query("select distinct p" +
            " from Pessoa p " +
            "inner join p.enderecos e")
    List<PessoaEntity> pessoaQuePossuemEndereco();

    @Query(value = "select * from PESSOA p " +
            "LEFT JOIN PESSOA_X_PESSOA_ENDERECO pxp ON (pxp.ID_PESSOA = p.ID_PESSOA) " +
            "WHERE pxp.ID_ENDERECO IS null", nativeQuery = true)
    List<PessoaEntity> pessoaSemEndereco();
}
