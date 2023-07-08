package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.domain.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    Cliente findByCpf(String cpf);

}
