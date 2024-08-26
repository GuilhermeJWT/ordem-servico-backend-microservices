package br.com.systemsgs.vendaservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_vendas")
public class ModelVendas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "id_gen_vendas",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id_gen_vendas", sequenceName = "vendas_seq", initialValue = 2, allocationSize = 1)
    @Column(name = "id_venda")
    private Long idVenda;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "data_venda")
    private LocalDateTime dataVenda = LocalDateTime.now();

    @Column(name = "total_venda", nullable = false)
    private BigDecimal totalVenda = BigDecimal.ZERO;

    @Column(name = "desconto")
    private BigDecimal desconto = BigDecimal.ZERO;

    @Column(name = "total_itens")
    private Integer totalItens;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ModelClientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_tecnico_responsavel")
    private ModelTecnicoResponsavel tecnicoResponsavel;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ModelItensVendas> itens = new ArrayList<>();

}
