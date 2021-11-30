package com.dbc.Veiculoprodutorconsumidor.service;

import com.dbc.Veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.Veiculoprodutorconsumidor.repository.VeiculoRepository;
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

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final VeiculoRepository veiculoRepository;
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;



    @KafkaListener(
            topics = "${kafka.topic.string}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory"
    )
    public void consumeDto(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        VeiculoDTO veiculoDTO = objectMapper.readValue(mensagem, VeiculoDTO.class);
        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", veiculoDTO, key, offset);
        veiculoRepository.save(veiculoDTO);
    }

    public List<VeiculoDTO> findAll() {
        return veiculoRepository.findAll();
    }



}
