package br.com.systemsgs.cadastrosservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorResponse {

      @JsonProperty("codigo_fornecedor")
      private Long id;

      @JsonProperty("nome_fornecedor")
      private String nome;

      @JsonProperty("tipo_pessoa")
      private String tipoPessoa;
}
