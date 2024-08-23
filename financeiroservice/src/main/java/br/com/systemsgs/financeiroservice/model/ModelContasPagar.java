package br.com.systemsgs.financeiroservice.model;

import br.com.systemsgs.financeiroservice.enums.FormaPagamento;
import br.com.systemsgs.financeiroservice.enums.StatusContas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tbl_contas_pagar")
public class ModelContasPagar implements Serializable {

    private static final long serialVersionUID = 1L;

    @MongoId
    private Long id;
    private Date data_vencimento;
    private Date data_emissao = new Date();
    private BigDecimal valor = BigDecimal.ZERO;
    private String observacao;
    private FormaPagamento formaPagamento;
    private StatusContas statusContas;
    private ModelFornecedor fornecedor;
}
