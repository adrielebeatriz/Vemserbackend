package com.dbc.Veiculoprodutorconsumidor.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "Veiculo")
public class VeiculoDTO {
    @NotEmpty
    @NotNull
    private Double velocidade;
    @NotEmpty
    @NotNull
    private LocalDateTime dataLeitura;
    @NotEmpty
    @NotNull
    private Integer rotacao;
    @NotEmpty
    @NotNull
    private Boolean sensorFrenagem;
}
