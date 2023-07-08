package com.github.alemarcelinos.msclientes.application.impl;

import com.github.alemarcelinos.msclientes.application.ClienteService;
import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.exceptions.ObjectNotFoundException;
import com.github.alemarcelinos.msclientes.domain.Cliente;
import com.github.alemarcelinos.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ModelMapper mapper;
    private final ClienteRepository repository;


    @Override
    public Cliente save(ClienteDTO clienteDTO) {
        return repository.save(mapper.map(clienteDTO, Cliente.class));
    }

    @Override
    public Cliente update(ClienteDTO obj) {
        findByCpf(obj.getCpf());
        return repository.save(mapper.map(obj, Cliente.class));
    }

    public Optional<ClienteDTO> findByCpf(String cpf) {
        Optional<ClienteDTO> obj = repository.findByCpf(cpf);
        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!")));
    }
}
