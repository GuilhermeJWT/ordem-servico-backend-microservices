package br.com.systemsgs.osservice.model;

import br.com.systemsgs.osservice.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_ordemservico")
public class ModelOrdemServico implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "id_ordem_servico_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id_ordem_servico_gen", sequenceName = "ordemservico_seq", initialValue = 2, allocationSize = 1)
    private Long id;

    @Column(name = "defeito", length = 250)
    private String defeito;

    @Column(name = "descricao", length = 250)
    private String descricao;

    @Column(name = "laudo_tecnico", length = 250)
    private String laudo_tecnico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30)
    private Status status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    @Column(name = "data_inicial")
    private Date data_inicial;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    @Column(name = "data_final")
    private Date data_final;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ModelClientes cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private ModelTecnicoResponsavel tecnicoResponsavel;
}
