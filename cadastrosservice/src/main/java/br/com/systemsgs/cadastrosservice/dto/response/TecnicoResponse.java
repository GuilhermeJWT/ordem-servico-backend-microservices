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
public class TecnicoResponse {

      @JsonProperty("codigo_tecnico_responsavel")
      private Long id;

      @JsonProperty("nome_tecnico_responsavel")
      private String nome;

}