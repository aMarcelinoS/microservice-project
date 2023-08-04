package com.github.alemarcelinos.msclientes.application.impl;

import com.github.alemarcelinos.msclientes.application.dto.ClienteDTO;
import com.github.alemarcelinos.msclientes.application.impl.exceptions.ObjectNotFoundException;
import com.github.alemarcelinos.msclientes.domain.Cliente;
import com.github.alemarcelinos.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class ClienteServiceImplTest {

    public static final long ID = 1L;
    public static final String CPF = "001.002.003-00";
    public static final String NOME = "Roberto";
    public static final Integer IDADE = 30;

    @InjectMocks
    private ClienteServiceImpl service;

    @Mock
    private ClienteRepository repository;

    @Mock
    private ModelMapper mapper;

    private Cliente cliente;
    private ClienteDTO clienteDTO;
    private Optional<Cliente> optCliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //<- inicia os mocks da classe testada.
        startCliente();
    }

    @Test
    void whenFindByIdThenReturnAClienteInstance() {
        when(repository.findById(Mockito.anyLong())).thenReturn(optCliente);

        Cliente response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Cliente.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(CPF, response.getCpf());
        assertEquals(NOME, response.getNome());
        assertEquals(IDADE, response.getIdade());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(Mockito.anyLong())).thenThrow(new ObjectNotFoundException("Cliente id " + ID + " não encontrado!"));

        try {
            service.findById(ID);
        } catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Cliente id " + ID + " não encontrado!", ex.getMessage());
        }
    }

    @Test
    void save() {
    }

    @Test
    void findByCpf() {
    }

    private void startCliente() {
        cliente = new Cliente(ID, CPF, NOME, IDADE);
        clienteDTO = new ClienteDTO(cliente);
        optCliente = Optional.of(new Cliente(ID, CPF, NOME, IDADE));
    }


}