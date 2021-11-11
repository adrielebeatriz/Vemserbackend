package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {

    @Query("select p " +
            " from ENDERECO_PESSOA p " +
            "where upper(pais) = :pais ")
    List<EnderecoEntity> enderecoByCountry(String pais);
    @Query("select ep from ENDERECO_PESSOA ep " +
            "join ep.pessoas p where p.idPessoa = ?1")
    List<EnderecoEntity> endercoByPerson(Integer idPessoa);

    @Query(value = "select * from VEM_SER.ENDERECO_PESSOA ep " +
            "where ep.PAIS = ?1 or ep.CIDADE = ?2 ", nativeQuery = true)
    List<EnderecoEntity> enderecoCountryCity(String pais, String Cidade);

    @Query(value = "select * from ENDERECO_PESSOA ep " +
            "where ep.COMPLEMENTO is  null", nativeQuery = true)
    List<EnderecoEntity> enderecoSemComplemento();

    @Query(value = "select p from ENDERECO_PESSOA p where upper(p.cep) like upper(?1)")
    Page<EnderecoEntity> findByCepPQL(String cep, Pageable pageable);
    @Query("select p " +
            " from ENDERECO_PESSOA p " +
            "where upper(pais) = :pais ")
    Page<EnderecoEntity> findByPaisPQL(String pais,Pageable pageable );
}