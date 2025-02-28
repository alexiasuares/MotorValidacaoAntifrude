package com.verificacaoConfiabilidade.service;
import org.springframework.stereotype.Service;

@Service
public class ValidaCPF {
    public boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+") || cpf.chars().distinct().count() == 1) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        return (cpf.charAt(9) - '0' == primeiroDigito) && (cpf.charAt(10) - '0' == segundoDigito);
    }
}
