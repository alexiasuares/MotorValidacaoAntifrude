package com.verificacaoConfiabilidade.service;

import com.consultador.ConsultaCep;
import com.verificacaoConfiabilidade.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

@Service
public class VerificacaoService {

    private final ValidaCPF validarCPF;
    private final ValidaEmail validarEmail;
    private final ValidaNome validarNome;
    private final ValidaTelefone validarTelefone;
    private final ValidaData validarData;
    private ConsultaCep consultaCEP;

    @Autowired
    public VerificacaoService(ValidaCPF validarCPF, ValidaEmail validarEmail, ValidaNome validarNome, ValidaTelefone validarTelefone, ValidaData validarData, ConsultaCep consultaCEP) {
        this.validarCPF = validarCPF;
        this.validarEmail = validarEmail;
        this.validarNome = validarNome;
        this.validarTelefone = validarTelefone;
        this.validarData = validarData;
        this.consultaCEP = consultaCEP;
    }

    public Map<String, Integer> validarDados(Client cliente) {
        Map<String, Integer> pontuacoes = new HashMap<>();
    
        pontuacoes.put("cpf", validarCPF.validarCPF(cliente.getCpf()) ? getPontuacaoValida() : 0);
        pontuacoes.put("nome", validarNome.validarNome(cliente.getNome()) ? getPontuacaoValida() : 0);
        pontuacoes.put("telefone", validarTelefone.validarTelefone(cliente.getTelefone()) ? getPontuacaoValida() : 0);
        pontuacoes.put("email", validarEmail.validarEmail(cliente.getEmail()) ? getPontuacaoValida() : 0);
        pontuacoes.put("nomeMae", validarNome.validarNome(cliente.getNomeMae()) ? getPontuacaoValida() : 0);
        pontuacoes.put("dataNascimento", validarData.validarDataNascimento(cliente.getDataNascimento()) ? getPontuacaoValida() : 0);

        try {
            String endereco = consultaCEP.consultaCEP(cliente.getCep());
            pontuacoes.put("cep", (endereco != null && !endereco.isEmpty()) ? getPontuacaoValida() : 0);
        } catch (Exception e) {
            pontuacoes.put("cep", 0); 
        }

        return pontuacoes;
    }
    
    private int getPontuacaoValida() {
        return new Random().nextInt(11); 
    }
    
    public double calcularGrauConfiabilidade(Map<String, Integer> pontuacoes) {
        double soma = pontuacoes.values().stream().mapToInt(Integer::intValue).sum();
        return soma / pontuacoes.size();
    }
}
