package br.com.systemsgs.cadastrosservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ModelTecnicoRequest {

    private Long id;

    @Size(max = 250, message = "{nome.maximo.caracteres}")
    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;
}
