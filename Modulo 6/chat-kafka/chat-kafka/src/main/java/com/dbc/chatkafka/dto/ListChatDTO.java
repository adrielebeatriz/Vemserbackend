package com.dbc.chatkafka.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListChatDTO {
    private List<String> nomeUsuario;
    private ChatDTO chatDTO;

}
