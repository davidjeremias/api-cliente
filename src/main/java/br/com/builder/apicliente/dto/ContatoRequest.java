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
public class ContatoRequest implements Serializable {

    private static final long serialVersionUID = 6195580614807336677L;

    private String telefoneMovel;

    private String telefoneFixo;

    @NotBlank
    private String email;
}
