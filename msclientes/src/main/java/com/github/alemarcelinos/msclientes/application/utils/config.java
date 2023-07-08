package com.github.alemarcelinos.msclientes.application.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
