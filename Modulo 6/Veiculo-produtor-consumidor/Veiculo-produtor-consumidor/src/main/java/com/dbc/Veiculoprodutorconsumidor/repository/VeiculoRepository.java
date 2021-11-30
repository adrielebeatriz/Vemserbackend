package com.dbc.Veiculoprodutorconsumidor.repository;

import com.dbc.Veiculoprodutorconsumidor.dto.VeiculoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoDTO, String> {
}
