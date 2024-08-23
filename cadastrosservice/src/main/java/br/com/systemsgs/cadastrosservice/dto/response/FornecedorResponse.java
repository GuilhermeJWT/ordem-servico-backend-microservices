package br.com.systemsgs.cadastrosservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FornecedorResponse

   (
      @JsonProperty("codigo_fornecedor") Long id,
      @JsonProperty("nome_fornecedor") String nome,
      @JsonProperty("tipo_pessoa")String tipoPessoa
   ){}
