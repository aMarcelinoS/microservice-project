package com.github.alemarcelinos.msclientes.application.dto;

import com.github.alemarcelinos.msclientes.domain.Cliente;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;

@Data
@RequiredArgsConstructor
public class ClienteDTO {

    private Long id;
    private String cpf;
    private String nome;
    private Integer idade;

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.nome = obj.getNome();
        this.idade = obj.getIdade();
    }
}
