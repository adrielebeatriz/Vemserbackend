package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.kafka.Producer;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MeuNovoSchedulerCron {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("HH:mm:ss");
    private final PessoaRepository pessoaRepository;

    private final Producer producer;
    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @Scheduled(cron = "0 0 0 8,18 * *", zone = "GMT-3")
    public void meuPrimeiroScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
//        Thread.sleep(1000);
        log.info("{}", dateFormat.format(new Date()));
        List<PessoaEntity> pessoaEntities = pessoaRepository.pessoaSemEndereco();
        for(PessoaEntity pessoa : pessoaEntities){
            System.out.println(pessoa.getIdPessoa());
            PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
            emailService.enviarEmailComTemplatePessoaSemEndereco(pessoaDTO);
        }
    }
    @Scheduled(cron = "0 0 0 23 12 *", zone = "GMT-3")
    public void meuSegundoScheduler() throws InterruptedException {
        List<PessoaEntity> todasAsPessoas  = pessoaRepository.findAll();
        for (PessoaEntity pessoa: todasAsPessoas) {
            emailService.enviarEmailChristmans(pessoa);
        }

    }
    @Scheduled(cron = "0 05 9 * * *", zone = "GMT-3")
    public void schedulerKafka() throws InterruptedException, JsonProcessingException {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setAssunto("Homework");
        emailDTO.setDestinatario("adriele.beatriz98@outlook.com");
        emailDTO.setTexto("Teste homework");
        producer.sendMessageDTO(emailDTO);
        }

}
