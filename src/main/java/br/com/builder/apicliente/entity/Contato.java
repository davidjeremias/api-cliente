package br.com.builder.apicliente.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = 6228564425343535730L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "tel_movel")
    private String telefoneMovel;

    @Column(name = "tel_fixo")
    private String telefoneFixo;

    @Column(name = "email")
    private String email;
}
