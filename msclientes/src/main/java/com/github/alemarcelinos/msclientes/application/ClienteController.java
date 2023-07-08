package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.impl.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServiceImpl service;
    private final ModelMapper mapper;

    @GetMapping
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> saveClient(@RequestBody ClienteDTO obj){
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(service.save(obj))
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<ClienteDTO> findByCpf(@RequestParam("cpf") String cpf){
        return ResponseEntity.ok().body(mapper.map(service.findByCpf(cpf), ClienteDTO.class));
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable String cpf, @RequestBody ClienteDTO obj){
        return ResponseEntity.ok().body(mapper.map(service.update(obj), ClienteDTO.class));
    }
}
