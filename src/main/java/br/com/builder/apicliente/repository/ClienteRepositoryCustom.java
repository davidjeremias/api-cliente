package br.com.builder.apicliente.repository;

import br.com.builder.apicliente.entity.Cliente;

import java.util.List;

public interface ClienteRepositoryCustom {

    List<Cliente> findByNomeOrCpfCnpjOrDataNascimentoOrAtivo(String nome, String cpfCnpj, String dataNascimento, Boolean ativo);
}
