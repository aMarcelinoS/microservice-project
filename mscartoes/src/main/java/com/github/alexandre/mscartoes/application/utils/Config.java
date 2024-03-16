package com.github.alexandre.mscartoes.application.utils;

import com.github.alexandre.mscartoes.infra.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Config {

    private CardRepository cardRepository;

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
