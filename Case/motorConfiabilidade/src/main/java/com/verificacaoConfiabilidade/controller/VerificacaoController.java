package com.verificacaoConfiabilidade.controller;
import com.verificacaoConfiabilidade.model.Client;
import com.verificacaoConfiabilidade.service.VerificacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VerificacaoController {
    @Autowired
    private final VerificacaoService verificacaoService;

    
    public VerificacaoController(VerificacaoService verificacaoService) {
        this.verificacaoService = verificacaoService;
    }

    @PostMapping("/validar")
    public ResponseEntity<Map<String, Object>> validar(@RequestBody Client cliente) {
        Map<String, Integer> pontuacoes = verificacaoService.validarDados(cliente);
        double grauConfiabilidade = verificacaoService.calcularGrauConfiabilidade(pontuacoes);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("grauConfiabilidade", grauConfiabilidade);

        return ResponseEntity.ok(resposta);
    }
}
