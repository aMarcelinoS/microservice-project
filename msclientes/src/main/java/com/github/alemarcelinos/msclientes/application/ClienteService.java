package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.domain.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente findById(Long id);
    Cliente save(ClienteDTO clienteDTO);
}
