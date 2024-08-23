package br.com.systemsgs.cadastrosservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TecnicoResponse

    (
       @JsonProperty("codigo_tecnico_responsavel") Long id,
       @JsonProperty("nome_tecnico_responsavel")String nome
    ){}