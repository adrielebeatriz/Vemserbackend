package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class EmailController {
    private final Producer producer;


    @PostMapping("/mensagem")
    public void enviarMensagem(@RequestBody EmailDTO emailDTO) throws JsonProcessingException {
        producer.sendMessageDTO(emailDTO);
    }

}
