package com.github.alemarcelinos.msclientes.application.impl;

import com.github.alemarcelinos.msclientes.application.ClienteService;
import com.github.alemarcelinos.msclientes.application.exceptions.ObjectNotFoundException;
import com.github.alemarcelinos.msclientes.domain.Cliente;
import com.github.alemarcelinos.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;


    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        Optional<Cliente> obj = repository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));
    }
}
