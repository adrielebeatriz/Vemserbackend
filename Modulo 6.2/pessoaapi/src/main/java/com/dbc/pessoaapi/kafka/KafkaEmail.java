package com.dbc.pessoaapi.kafka;




import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class KafkaEmail {
    private final Producer producer;
    private final Configuration configuration;

    public void enviaKafka(PessoaEntity pessoaEntity, String templateHtml) throws MessagingException, IOException, TemplateException {
        Template template = configuration.getTemplate(templateHtml);
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getNome());

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setAssunto("Envio de mensagem!");
        emailDTO.setDestinatario(pessoaEntity.getEmail());
        emailDTO.setTexto(html);
        producer.sendMessageDTO(emailDTO);

    }

}
