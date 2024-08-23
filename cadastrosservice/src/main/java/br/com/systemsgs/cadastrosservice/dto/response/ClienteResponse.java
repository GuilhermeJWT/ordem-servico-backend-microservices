package br.com.systemsgs.cadastrosservice.dto.response;

import br.com.systemsgs.cadastrosservice.model.ModelEndereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    @JsonProperty("codigo_cliente")
    private Long id;

    @JsonProperty("nome_cliente")
    private String nome;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("email")
    private String email;

    @JsonProperty("endereco_cliente")
    private ModelEndereco endereco;
}

