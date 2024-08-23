package br.com.systemsgs.cadastrosservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_tecnico_responsavel")
public class ModelTecnicoResponsavel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "id_gen_tecnico",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id_gen_tecnico", sequenceName = "tecnico_seq", initialValue = 2, allocationSize = 1)
    private Long id;

    @Column(name = "nome", length = 150)
    private String nome;
}
