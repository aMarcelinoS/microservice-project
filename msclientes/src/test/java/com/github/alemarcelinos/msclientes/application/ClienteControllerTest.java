package com.github.alemarcelinos.msclientes.application;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.impl.ClienteServiceImpl;
import com.github.alemarcelinos.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RequiredArgsConstructor
class ClienteControllerTest {

    public static final long ID = 1L;
    public static final String CPF = "001.002.003-00";
    public static final String NOME = "Roberto";
    public static final Integer IDADE = 30;

    @InjectMocks
    private ClienteController controller;

    @Mock
    private ClienteServiceImpl service;

    @Mock
    private ModelMapper mapper;

    private Cliente cliente;
    private ClienteDTO clienteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void status() {
    }

    @Test
    void whenGetByIdThenReturnSuccess() {
        when(service.findById(anyLong())).thenReturn(cliente);
        when(mapper.map(any(), any())).thenReturn(clienteDTO);

        ResponseEntity<ClienteDTO> response = controller.getById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ClienteDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(CPF, response.getBody().getCpf());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(IDADE, response.getBody().getIdade());

        assertEquals(HttpStatus.OK.is2xxSuccessful(), response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void saveClient() {
    }

    @Test
    void findByCpf() {
    }

    private void startUser() {
        cliente = new Cliente(ID, CPF,NOME, IDADE);
        clienteDTO = new ClienteDTO(cliente);
    }
}