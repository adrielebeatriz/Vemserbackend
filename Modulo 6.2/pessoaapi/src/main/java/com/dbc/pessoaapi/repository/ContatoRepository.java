package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query("select c from CONTATO c where c.tipoContato = :tipoContato")
    List<ContatoEntity> contatoPorTipo(TipoContato tipoContato);

    @Query(value = "select * from CONTATO c WHERE c.ID_PESSOA = ?1",nativeQuery = true)
    List<ContatoEntity> contatoPotIdPessoa(Integer idContato);


}
