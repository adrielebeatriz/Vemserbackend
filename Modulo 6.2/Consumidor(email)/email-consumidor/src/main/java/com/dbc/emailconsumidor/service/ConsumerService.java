package com.dbc.emailconsumidor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.dbc.emailconsumidor.dto.EmailDTO;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    @KafkaListener(
            topics = "${kafka.topic.email}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory"
    )
    public void consumeGeral(@Payload String mensagem,
                             @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                             @Header(KafkaHeaders.OFFSET) Long offset) throws IOException, MessagingException, TemplateException {
        EmailDTO enviaEmailDTO = objectMapper.readValue(mensagem, EmailDTO.class);
        emailService.enviaEmail(enviaEmailDTO);

        log.info("{} [{}] {}", enviaEmailDTO.getAssunto(), enviaEmailDTO.getDestinatario(), enviaEmailDTO.getTexto());

    }


}
