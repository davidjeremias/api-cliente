package br.com.builder.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse implements Serializable {

    private static final long serialVersionUID = 9065689554057553907L;

    private Long id;

    private String nome;

    private String cpfCnpj;

    private Long idade;

    private LocalDate dataNascimento;

    private Boolean ativo;

    private EnderecoResponse endereco;

    private ContatoResponse contato;
}
