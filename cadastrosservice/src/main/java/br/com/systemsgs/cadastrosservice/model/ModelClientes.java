package br.com.systemsgs.cadastrosservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_clientes")
public class ModelClientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "id_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id_gen", sequenceName = "clientes_seq", initialValue = 2, allocationSize = 1)
    private Long id;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "cpf", length = 20)
    private String cpf;

    @Column(name = "celular", length = 25)
    private String celular;

    @Column(name = "email", length = 100)
    private String email;

    @Embedded
    private ModelEndereco endereco;
}
