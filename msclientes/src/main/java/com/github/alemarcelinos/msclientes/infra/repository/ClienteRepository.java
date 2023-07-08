package com.github.alemarcelinos.msclientes.infra.repository;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Transactional(readOnly = true)
    Optional<ClienteDTO> findByCpf(String cpf);
}
