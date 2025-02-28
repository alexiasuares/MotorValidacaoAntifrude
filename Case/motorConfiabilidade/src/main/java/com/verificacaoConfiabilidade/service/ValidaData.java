package com.verificacaoConfiabilidade.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Service;

@Service
public class ValidaData {
    private static final int  idade_max= 120;
    public boolean validarDataNascimento(String dataNascimento) {
        try {
            LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate dataAtual = LocalDate.now();
            LocalDate limite = dataAtual.minusYears(idade_max);

            return !data.isAfter(dataAtual) && !data.isBefore(limite);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
