package br.com.builder.apicliente.builders;

import br.com.builder.apicliente.dto.ClienteResponse;
import br.com.builder.apicliente.entity.Cliente;

import java.time.LocalDate;

public class ClienteBuilder {

    private Cliente cliente;

    private ClienteBuilder() {
    }

    public static ClienteBuilder umCliente() {
        ClienteBuilder builder = new ClienteBuilder();
        builder.cliente = new Cliente();
        builder.cliente.setId(1L);
        builder.cliente.setNome("David Jeremias");
        builder.cliente.setCpfCnpj("01696587166");
        builder.cliente.setDataNascimento(LocalDate.of(1986, 10, 01));
        builder.cliente.setAtivo(Boolean.TRUE);
        return builder;
    }

    public Cliente agora() {
        return cliente;
    }
}
