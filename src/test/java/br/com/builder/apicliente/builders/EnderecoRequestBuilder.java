package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.EnderecoRequest;

public class EnderecoRequestBuilder {

    private EnderecoRequest enderecoRequest;

    private EnderecoRequestBuilder() {
    }

    public static EnderecoRequestBuilder umEnderecoRequest() {
        EnderecoRequestBuilder builder = new EnderecoRequestBuilder();
        builder.enderecoRequest = new EnderecoRequest();
        builder.enderecoRequest.setCep("72544406");
        builder.enderecoRequest.setLogradouro("Qr 214 Conjunto F");
        builder.enderecoRequest.setNumero("25");
        builder.enderecoRequest.setBairro("Santa Maria");
        builder.enderecoRequest.setLocalidade("Brasilia");
        builder.enderecoRequest.setUf("DF");
        return builder;
    }

    public EnderecoRequest agora() {
        return enderecoRequest;
    }
}
