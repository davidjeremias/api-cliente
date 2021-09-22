package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.ClienteRequest;
import br.com.builder.apicliente.dto.ClienteResponse;

import java.time.LocalDate;

public class ClienteResponseBuilder {

    private ClienteResponse clienteResponse;

    private ClienteResponseBuilder() {}

    public static ClienteResponseBuilder umClienteResponse() {
        ClienteResponseBuilder builder = new ClienteResponseBuilder();
        builder.clienteResponse = new ClienteResponse();
        builder.clienteResponse.setNome("David Jeremias");
        builder.clienteResponse.setCpfCnpj("01696587166");
        builder.clienteResponse.setDataNascimento(LocalDate.of(1986, 10, 01));
        builder.clienteResponse.setAtivo(Boolean.TRUE);
        builder.clienteResponse.setEndereco(EnderecoResponseBuilder.umEnderecoResponse().agora());
        builder.clienteResponse.setContato(ContatoResponseBuilder.umContatoResponse().agora());
        return builder;
    }

    public ClienteResponse agora() {
        return clienteResponse;
    }
}
