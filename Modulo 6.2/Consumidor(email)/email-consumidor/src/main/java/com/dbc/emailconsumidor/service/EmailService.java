package com.dbc.emailconsumidor.service;


import com.dbc.emailconsumidor.dto.EmailDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    private final Configuration configuration;



    public EmailDTO enviaEmail(EmailDTO emailDTO) throws MessagingException, IOException, TemplateException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(remetente);
        helper.setTo(emailDTO.getDestinatario());
        helper.setSubject(emailDTO.getAssunto());
        helper.setText(emailDTO.getTexto(), true);
        emailSender.send(mimeMessage);

        return emailDTO;
    }
}

