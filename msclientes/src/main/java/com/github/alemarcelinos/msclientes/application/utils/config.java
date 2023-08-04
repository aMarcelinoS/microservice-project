package com.github.alemarcelinos.msclientes.application.utils;

import com.github.alemarcelinos.msclientes.domain.Cliente;
import com.github.alemarcelinos.msclientes.infra.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class config {

    private ClienteRepository repository;

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public void startDB() {
        Cliente cli1 = new Cliente(null,"001.123.321-00", "Alexandre", 28);
        Cliente cli2 = new Cliente(null,"001.123.321-02", "Marília", 30);

        repository.saveAll(List.of(cli1, cli2));
    }
}
