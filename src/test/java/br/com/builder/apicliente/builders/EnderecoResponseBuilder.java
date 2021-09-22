package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.EnderecoResponse;

public class EnderecoResponseBuilder {

    private EnderecoResponse enderecoResponse;

    private EnderecoResponseBuilder() {
    }

    public static EnderecoResponseBuilder umEnderecoResponse() {
        EnderecoResponseBuilder builder = new EnderecoResponseBuilder();
        builder.enderecoResponse = new EnderecoResponse();
        builder.enderecoResponse.setId(1L);
        builder.enderecoResponse.setCep("72544406");
        builder.enderecoResponse.setLogradouro("Qr 214 Conjunto F");
        builder.enderecoResponse.setNumero("25");
        builder.enderecoResponse.setBairro("Santa Maria");
        builder.enderecoResponse.setLocalidade("Brasilia");
        builder.enderecoResponse.setUf("DF");
        return builder;
    }

    public EnderecoResponse agora() {
        return enderecoResponse;
    }
}
