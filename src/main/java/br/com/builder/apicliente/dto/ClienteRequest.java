package br.com.builder.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest implements Serializable {

    private static final long serialVersionUID = 3971837210787356967L;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpfCnpj;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private Boolean ativo;

    @NotNull
    private EnderecoRequest endereco;

    @NotNull
    private ContatoRequest contato;
}
