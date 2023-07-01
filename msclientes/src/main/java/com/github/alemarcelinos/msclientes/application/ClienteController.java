package com.github.alemarcelinos.msclientes.application;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String status(){
        return "Ok";
    }
}
