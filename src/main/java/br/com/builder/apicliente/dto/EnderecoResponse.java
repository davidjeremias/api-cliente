package br.com.builder.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse implements Serializable {

    private static final long serialVersionUID = 5804727083782095350L;

    private Long id;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String numero;

    private String localidade;

    private String uf;
}
