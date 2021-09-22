package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.ClienteRequest;
import br.com.builder.apicliente.dto.ContatoRequest;

import java.time.LocalDate;

public class ClienteRequestBuilder {

    private ClienteRequest clienteRequest;

    private ClienteRequestBuilder() {
    }

    public static ClienteRequestBuilder umClienteRequest() {
        ClienteRequestBuilder builder = new ClienteRequestBuilder();
        builder.clienteRequest = new ClienteRequest();
        builder.clienteRequest.setNome("David Jeremias");
        builder.clienteRequest.setCpfCnpj("01696587166");
        builder.clienteRequest.setDataNascimento(LocalDate.of(1986, 10, 01));
        builder.clienteRequest.setAtivo(Boolean.TRUE);
        builder.clienteRequest.setEndereco(EnderecoRequestBuilder.umEnderecoRequest().agora());
        builder.clienteRequest.setContato(ContatoRequestBuilder.umContatoRequest().agora());
        return builder;
    }

    public ClienteRequest agora() {
        return clienteRequest;
    }
}
