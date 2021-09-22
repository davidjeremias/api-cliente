package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.ContatoRequest;

public class ContatoRequestBuilder {

    private ContatoRequest contatoRequest;

    private ContatoRequestBuilder() {
    }

    public static ContatoRequestBuilder umContatoRequest() {
        ContatoRequestBuilder builder = new ContatoRequestBuilder();
        builder.contatoRequest = new ContatoRequest();
        builder.contatoRequest.setEmail("com1.com3@gmail.com");
        builder.contatoRequest.setTelefoneFixo("6133946018");
        builder.contatoRequest.setTelefoneMovel("61986460330");
        return builder;
    }

    public ContatoRequest agora() {
        return contatoRequest;
    }
}
