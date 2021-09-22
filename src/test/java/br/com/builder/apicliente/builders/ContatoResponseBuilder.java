package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.ContatoResponse;

public class ContatoResponseBuilder {

    private ContatoResponse contatoResponse;

    private ContatoResponseBuilder() {
    }

    public static ContatoResponseBuilder umContatoResponse() {
        ContatoResponseBuilder builder = new ContatoResponseBuilder();
        builder.contatoResponse = new ContatoResponse();
        builder.contatoResponse.setId(1L);
        builder.contatoResponse.setEmail("com1.com3@gmail.com");
        builder.contatoResponse.setTelefoneFixo("6133946018");
        builder.contatoResponse.setTelefoneMovel("61986460330");
        return builder;
    }

    public ContatoResponse agora() {
        return contatoResponse;
    }
}
