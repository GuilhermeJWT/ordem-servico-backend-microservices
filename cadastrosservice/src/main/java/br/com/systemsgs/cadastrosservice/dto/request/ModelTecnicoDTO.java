package br.com.systemsgs.cadastrosservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelTecnicoDTO {

    private Long id;

    @Size(max = 250, message = "{nome.maximo.caracteres}")
    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;
}
