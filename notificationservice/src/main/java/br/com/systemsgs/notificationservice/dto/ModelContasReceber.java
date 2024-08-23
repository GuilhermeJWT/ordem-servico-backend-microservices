package br.com.systemsgs.notificationservice.dto;

import br.com.systemsgs.notificationservice.enums.FormaPagamento;
import br.com.systemsgs.notificationservice.enums.StatusContas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelContasReceber implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date data_vencimento;
    private BigDecimal valor = BigDecimal.ZERO;
    private Date data_emissao = new Date();
    private String observacao;
    private FormaPagamento formaPagamento;
    private StatusContas statusContasReceber;
    private Long codigoCliente;

}
