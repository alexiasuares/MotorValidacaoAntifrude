package com.verificacaoConfiabilidade.config;

import com.consultador.ConsultaCep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ConsultaCep consultaCep() {
        return new ConsultaCep();
    }
}
