package com.dbc.chatkafka.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ChatDTO {

    @NotEmpty
    @NotNull
    private  String usuario;
    @NotEmpty
    @NotNull
    private String mensagem;
    @NotNull
    private LocalDateTime dataAtual;

}
