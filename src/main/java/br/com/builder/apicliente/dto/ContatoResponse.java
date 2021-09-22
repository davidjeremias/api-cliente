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
public class ContatoResponse implements Serializable {

    private static final long serialVersionUID = 9112040310869383442L;

    private Long id;

    private String telefoneMovel;

    private String telefoneFixo;

    private String email;
}
