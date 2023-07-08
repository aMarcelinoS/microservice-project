package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.domain.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente save(ClienteDTO clienteDTO);
    Cliente update(ClienteDTO clienteDTO);
}
