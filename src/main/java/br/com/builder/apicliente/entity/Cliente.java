package br.com.builder.apicliente.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = -4364209972495968783L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ativo")
    private Boolean ativo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contato_id")
    private Contato contato;
}
