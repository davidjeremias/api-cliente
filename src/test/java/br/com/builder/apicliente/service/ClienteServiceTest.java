package br.com.builder.apicliente.service;

import br.com.builder.apicliente.builders.ClienteBuilder;
import br.com.builder.apicliente.builders.ClienteRequestBuilder;
import br.com.builder.apicliente.builders.ClienteResponseBuilder;
import br.com.builder.apicliente.dto.ClienteRequest;
import br.com.builder.apicliente.dto.ClienteResponse;
import br.com.builder.apicliente.dto.ContatoRequest;
import br.com.builder.apicliente.dto.EnderecoRequest;
import br.com.builder.apicliente.entity.Cliente;
import br.com.builder.apicliente.entity.Contato;
import br.com.builder.apicliente.entity.Endereco;
import br.com.builder.apicliente.exception.NegocioException;
import br.com.builder.apicliente.repository.ClienteRepository;
import br.com.builder.apicliente.repository.ClienteRepositoryCustom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteRepositoryCustom clienteRepositoryCustom;

    @Mock
    private static ModelMapper mapper;

    private static ClienteRequest clienteRequest;
    private static ClienteResponse clienteResponse;
    private static Cliente cliente;

    @BeforeAll
    public static void setup() {
        clienteRequest = ClienteRequestBuilder.umClienteRequest().agora();
        clienteResponse = ClienteResponseBuilder.umClienteResponse().agora();
        cliente = ClienteBuilder.umCliente().agora();
    }

    @Test
    public void save() {
        //cenario
        when(mapper.map(clienteRequest, Cliente.class)).thenReturn(cliente);
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        when(mapper.map(cliente, ClienteResponse.class)).thenReturn(clienteResponse);

        //ação
        Optional<ClienteResponse> response = service.save(clienteRequest);

        //verificação
        assertNotNull(response.get());
    }

    @Test
    public void findAllPageable() {
        //cenario
        Pageable pageable = PageRequest.of(0, 10);
        List<Cliente> clientes = Arrays.asList(cliente);
        Page<Cliente> clientesPage = new PageImpl<>(clientes, pageable, 1);
        when(repository.findAll(pageable)).thenReturn(clientesPage);
        when(mapper.map(cliente, ClienteResponse.class)).thenReturn(clienteResponse);

        //ação
        Page<ClienteResponse> response = service.findAllPageable(pageable);

        //verificação
        assertEquals(response.getTotalElements(), 1);
    }

    @Test
    public void update() {
        //cenario
        Long id = 1L;
        when(repository.findById(any(Long.class))).thenReturn(Optional.ofNullable(cliente));
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        when(mapper.map(cliente, ClienteResponse.class)).thenReturn(clienteResponse);

        //ação
        Optional<ClienteResponse> response = service.update(id, clienteRequest);

        //verificação
        assertEquals(response.isPresent(), true);
    }

    @Test
    public void deveNaoLocalizarCliente() {
        //cenario
        Long id = 10L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        //ação
        NegocioException exception = assertThrows(NegocioException.class, () -> {
            service.findById(id);
        });

        //verificação
        assertEquals("Cliente não encontrado!", exception.getMessage());
    }

    @Test
    public void deveCalcularIdade() {
        //cenario
        LocalDate dataNascimento = LocalDate.of(1986, 10, 01);

        //ação
        Long idade = service.calculaIdade(dataNascimento);

        //verificação
        assertEquals(idade, 34);
    }

    @Test
    public void devePesquisarComParametros(){
        //cenario
        String nome = "David";
        String cpfCnpj = null;
        String dataNascimento = null;
        Boolean ativo = Boolean.TRUE;
        List<Cliente> clientes = new ArrayList<>();
        when(clienteRepositoryCustom.findByNomeOrCpfCnpjOrDataNascimentoOrAtivo(nome, cpfCnpj, dataNascimento, ativo)).thenReturn(clientes);

        //ação
        List<ClienteResponse> clienteResponses = service.findWithParams(nome, cpfCnpj, dataNascimento, ativo);

        //verificação
        assertEquals(clienteResponses.isEmpty(), true);
    }
}
