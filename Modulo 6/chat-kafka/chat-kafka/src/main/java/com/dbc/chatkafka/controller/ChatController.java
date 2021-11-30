package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.dto.ChatDTO;
import com.dbc.chatkafka.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ChatController {
    private final Producer producer;


    @PostMapping("/enviarMensagemGeral")
    public void enviarMensagemGeral(@RequestBody ChatDTO chatDTO) throws JsonProcessingException {
        producer.sendMessageGeral(chatDTO);
    }

    @PostMapping("/enviarMensagemPrivada")
    public void enviarMensagemPrivada(@RequestBody ChatDTO chatDTO, @RequestParam (value = "topico")String topico) throws JsonProcessingException {
        producer.sendMessagePrivado(chatDTO,topico);
    }


}
