package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {

    @Query("select p " +
            " from ENDERECO_PESSOA p " +
            "where p.pais = ?1 ")
    List<EnderecoEntity> enderecoByCountry(String pais);
    @Query("select ep from ENDERECO_PESSOA ep " +
            "join ep.pessoas p where p.idPessoa = ?1")
    List<EnderecoEntity> endercoByPerson(Integer idPessoa);

    @Query(value = "select * from VEM_SER.ENDERECO_PESSOA ep " +
            "where ep.PAIS = ?1 or ep.CIDADE = ?2 ", nativeQuery = true)
    List<EnderecoEntity> enderecoCountryCity(String pais, String Cidade);
}