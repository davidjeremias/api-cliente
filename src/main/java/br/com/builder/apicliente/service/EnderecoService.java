package br.com.builder.apicliente.service;

import br.com.builder.apicliente.dto.AcrescimoRequest;
import br.com.builder.apicliente.dto.EnderecoResponse;
import br.com.builder.apicliente.entity.Endereco;
import br.com.builder.apicliente.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public Optional<EnderecoResponse> salvar(AcrescimoRequest acrescimoRequest) {
        Endereco endereco = modelMapper.map(acrescimoRequest, Endereco.class);
        EnderecoResponse enderecoResponse = modelMapper.map(repository.save(endereco), EnderecoResponse.class);
        return Optional.of(enderecoResponse);
    }

}
