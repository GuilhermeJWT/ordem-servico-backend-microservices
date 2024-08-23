package br.com.systemsgs.financeiroservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasPagarResponse {

    @JsonProperty("id_conta_pagar")
    private Long id;

    @JsonProperty("data_vencimento")
    private Date data_vencimento;

    @JsonProperty("valor_conta_pagar")
    private BigDecimal valor;

    @JsonProperty("observacao")
    private String observacao;

    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    @JsonProperty("status_conta_pagar")
    private String statusContas;

    @JsonProperty("nome_fornecedor")
    private String nomeFornecedor;
}
