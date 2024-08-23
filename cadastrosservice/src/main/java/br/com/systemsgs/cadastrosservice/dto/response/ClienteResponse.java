package br.com.systemsgs.cadastrosservice.dto.response;

import br.com.systemsgs.cadastrosservice.model.ModelEndereco;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteResponse

   (
      @JsonProperty("codigo_cliente") Long id,
      @JsonProperty("nome_cliente")String nome,
      @JsonProperty("celular")String celular,
      @JsonProperty("email")String email,
      @JsonProperty("endereco_cliente")ModelEndereco endereco
    ){}

