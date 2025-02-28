package com.verificacaoConfiabilidade.service;
import org.springframework.stereotype.Service;
@Service
public class ValidaTelefone {

    public boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return false;
        }

        String regex = "^[1-9][0-9]{1}9[0-9]{8}$"; // Exemplo: 11999999999 (11 dígitos)
        return telefone.matches(regex);
    }
}


