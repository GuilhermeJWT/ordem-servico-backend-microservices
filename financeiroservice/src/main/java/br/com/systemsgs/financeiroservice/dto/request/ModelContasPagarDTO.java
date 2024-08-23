package br.com.systemsgs.financeiroservice.dto.request;

import br.com.systemsgs.financeiroservice.enums.FormaPagamento;
import br.com.systemsgs.financeiroservice.enums.StatusContas;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelContasPagarDTO {

    private Long id;

    @FutureOrPresent(message = "{data.futuro}")
    @NotNull(message = "{data.vencimento}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    private Date data_vencimento;

    @NotNull(message = "{valor.obrigatorio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{preco.maior}")
    @DecimalMax(value = "999999.0", message = "{valor.alto}")
    private BigDecimal valor = BigDecimal.ZERO;

    @Size(max = 250, message = "{observacao.conta.maximo.caracteres}")
    private String observacao;

    @NotNull(message = "{forma.pagamento.obrigatoria}")
    @JsonProperty("forma_pagamento")
    private FormaPagamento formaPagamento;

    @NotNull(message = "{status.conta.obrigatoria}")
    @JsonProperty("status_contas")
    private StatusContas statusContas;

    @NotNull(message = "{fornecedor.obrigatorio}")
    @JsonProperty("codigo_fornecedor")
    private Long fornecedor;
}
