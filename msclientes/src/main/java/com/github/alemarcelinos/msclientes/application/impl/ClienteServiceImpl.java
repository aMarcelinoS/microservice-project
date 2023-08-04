package com.github.alemarcelinos.msclientes.application.impl;

import com.github.alemarcelinos.msclientes.application.ClienteService;
import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.impl.exceptions.DataIntegrityViolationException;
import com.github.alemarcelinos.msclientes.application.impl.exceptions.ObjectNotFoundException;
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
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente id " + id + " não encontrado!"
        ));
    }

    @Override
    public Cliente save(ClienteDTO clienteDTO) {
        if(repository.findByCpf(clienteDTO.getCpf()).isPresent()){
            throw new DataIntegrityViolationException("CPF já está em uso");
        }
        return repository.save(mapper.map(clienteDTO, Cliente.class));
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> obj = repository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("CPF não encontrado!"));
    }
}
