package com.dbc.chatkafka.service;


import com.dbc.chatkafka.dto.ChatDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;



    @KafkaListener(
            topics = "${kafka.topic.geral}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiro"
    )
    public void ConsumerMensagemGeral(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
         ChatDTO  chatDTO = objectMapper.readValue(mensagem, ChatDTO.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        log.info("DATA CRIAÇÃO: '{}', USUARIO: '{}', MENSAGEM: '{}'",
                formatter.format(chatDTO.getDataCriacao()), chatDTO.getUsuario(), chatDTO.getMensagem());

    }

    @KafkaListener(
            topics = "${kafka.topic.privado}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "segundo"
    )
    public void ConsumerMensagemPrivada(@Payload String mensagem,
                                      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                      @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ChatDTO  chatDTO = objectMapper.readValue(mensagem, ChatDTO.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        log.info("DATA CRIAÇÃO: '{}', USUARIO: '{}', MENSAGEM PRIAVADA: '{}'",
                formatter.format(chatDTO.getDataCriacao()) , chatDTO.getUsuario(), chatDTO.getMensagem());
    }



}
