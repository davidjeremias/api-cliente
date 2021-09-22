package br.com.builder.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest implements Serializable {

    private static final long serialVersionUID = 7343147070402634550L;

    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String numero;

    @NotBlank
    private String localidade;

    @NotBlank
    private String uf;
}
