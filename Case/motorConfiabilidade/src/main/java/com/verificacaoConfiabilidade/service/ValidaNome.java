package com.verificacaoConfiabilidade.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service

public class ValidaNome {
    private static final Logger logger = LoggerFactory.getLogger(ValidaNome.class);

    public boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            logger.info("Nome inválido: valor nulo ou vazio");
            return false;
        }

        String regex = "^[A-Za-zÀ-ú\\s]+$";
        String[] partes = nome.trim().split("\\s+");

        boolean valido = nome.matches(regex) && partes.length >= 2;
        logger.info("Validando nome: '{}' -> {}", nome, valido);

        return valido;
    }
}