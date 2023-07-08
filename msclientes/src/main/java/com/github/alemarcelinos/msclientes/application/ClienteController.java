package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.impl.ClienteServiceImpl;
import com.github.alemarcelinos.msclientes.domain.Cliente;
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
    private final ModelMapper modelMapper;

    @GetMapping
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity saveClient(@RequestBody ClienteDTO request){
       Cliente clienteDto = request.toModel();
       service.save(clienteDto);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(clienteDto.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<ClienteDTO> findByCpf(@RequestParam("cpf") String cpf){
        return ResponseEntity.ok().body(modelMapper.map(service.findByCpf(cpf), ClienteDTO.class));
    }

}
