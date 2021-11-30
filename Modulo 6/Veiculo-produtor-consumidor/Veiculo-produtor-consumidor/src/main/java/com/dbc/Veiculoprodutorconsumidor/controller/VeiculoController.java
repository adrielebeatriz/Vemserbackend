package com.dbc.Veiculoprodutorconsumidor.controller;

import com.dbc.Veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.Veiculoprodutorconsumidor.exception.RegraDeNegocioException;
import com.dbc.Veiculoprodutorconsumidor.kafka.Producer;
import com.dbc.Veiculoprodutorconsumidor.service.ConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class VeiculoController {
    private final Producer producer;
    private final ConsumerService consumerService;

    @PostMapping("/enviar")
    private void enviarMensagensTopicos(String mensagem) {
        producer.sendMessage(mensagem);
    }

    @PostMapping("/veiculo")
    public void inserirVeiculoKafka(@RequestBody VeiculoDTO veiculoDTO) throws JsonProcessingException {
        producer.sendMessageDTO(veiculoDTO);
    }

    @GetMapping
    public List<VeiculoDTO> list() throws RegraDeNegocioException {
        return consumerService.findAll();
    }

}
