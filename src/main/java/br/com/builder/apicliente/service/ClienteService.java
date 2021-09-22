package br.com.builder.apicliente.service;

import br.com.builder.apicliente.dto.ClienteRequest;
import br.com.builder.apicliente.dto.ClienteResponse;
import br.com.builder.apicliente.entity.Cliente;
import br.com.builder.apicliente.exception.NegocioException;
import br.com.builder.apicliente.repository.ClienteRepository;
import br.com.builder.apicliente.repository.ClienteRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteRepositoryCustom clienteCustomRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    ModelMapper modelMapper;

    public Optional<ClienteResponse> save(ClienteRequest clienteRequest) {
        Cliente cliente = modelMapper.map(clienteRequest, Cliente.class);
        repository.save(cliente);
        ClienteResponse clienteResponse = modelMapper.map(cliente, ClienteResponse.class);
        clienteResponse.setIdade(calculaIdade(cliente.getDataNascimento()));
        return Optional.of(clienteResponse);
    }

    public Page<ClienteResponse> findAllPageable(Pageable pageable) {
        Page<Cliente> clienteResponsePage = repository.findAll(pageable);
        List<ClienteResponse> clienteResponses = new ArrayList<>();
        for (Cliente cliente : clienteResponsePage.getContent()) {
            ClienteResponse clienteResponse = modelMapper.map(cliente, ClienteResponse.class);
            clienteResponse.setIdade(calculaIdade(cliente.getDataNascimento()));
            clienteResponses.add(clienteResponse);
        }
        return new PageImpl<ClienteResponse>(clienteResponses, clienteResponsePage.getPageable(), clienteResponsePage.getTotalElements());
    }

    public Optional<ClienteResponse> update(Long id, ClienteRequest clienteRequest) {
        Cliente cliente = findById(id);
        BeanUtils.copyProperties(clienteRequest, cliente, "id");
        return Optional.of(modelMapper.map(repository.save(cliente), ClienteResponse.class));
    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        cliente.orElseThrow(() ->{throw new NegocioException("Cliente não encontrado!");});
        return cliente.get();
    }

    public Long calculaIdade(LocalDate dataNascimento) {
        return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }

    public List<ClienteResponse> findWithParams(String nome, String cpfCnpj, String dataNascimento, Boolean ativo) {
        List<Cliente> clientes = clienteCustomRepository.findByNomeOrCpfCnpjOrDataNascimentoOrAtivo(nome, cpfCnpj, dataNascimento, ativo);
        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteResponse.class))
                .collect(Collectors.toList());
    }
}
