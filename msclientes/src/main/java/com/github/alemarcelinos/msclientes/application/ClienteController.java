package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.impl.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public String status(){
        return "OK";
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id), ClienteDTO.class));
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
}
