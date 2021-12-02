package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.controller.PessoaController;
import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaEnderecoDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String remetente;
    private final Configuration configuration;



    public void enviarEmailComTemplatePessoaSemEndereco(PessoaDTO pessoaDTO, String s) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("email");
        Template template = configuration.getTemplate("email-templatedelete.ftl");
        Map<String, Object> dados = new HashMap<>();
        dados.put("nomePessoa", pessoaDTO.getNome());
        dados.put("nomePessoa", pessoaDTO.getNome());
        dados.put("email", remetente);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void enviarEmailChristmans(PessoaEntity pessoaEntity, String s) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(remetente);
        message.setTo(pessoaEntity.getEmail());
        message.setSubject("Promoção de Natal");
        message.setText("Olá " + pessoaEntity.getNome() + "," +
                "\n\nSelecionamos algumas das nossas super promoções de natal na nossa plataforma especialmente para você:" +
                "\n-Na compra de 1CD do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico." +
                "\n-Na locação de um filme em VHS, a outra locação é grátis" +
                "\n-Fita de Super Nitendo com 50% de desconto." +
                "\n\nAproveite..." +
                "\nMagazine OldSchool");
        emailSender.send(message);
    }
    public EmailDTO enviarEmailComTemplateScheduleKafka(PessoaEntity pessoaEntity) {
        EmailDTO emailKafkaDTO = new EmailDTO();
        emailKafkaDTO.setDestinatario(pessoaEntity.getEmail());
        emailKafkaDTO.setAssunto("Atualize seu cadastro!");
        emailKafkaDTO.setTexto("Olá " +pessoaEntity.getNome()+ ", <br><br>" +
                "Estamos muito felizes que você está em nosso sistema. Para que possamos enviá-lo um brinde" +
                " exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro.");

        return emailKafkaDTO;
    }

}
