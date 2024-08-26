package br.com.systemsgs.osservice.dto.request;

import br.com.systemsgs.osservice.enums.Status;
import br.com.systemsgs.osservice.model.ModelClientes;
import br.com.systemsgs.osservice.model.ModelTecnicoResponsavel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelOrdemServicoDTO {

    private Long id;

    @Size(max = 250, message = "{defeito.maximo.caracteres}")
    private String defeito;

    @Size(max = 250, message = "{descricao.maximo.caracteres}")
    private String descricao;

    @Size(max = 250, message = "{laudo.tecnico.maximo.caracteres}")
    private String laudo_tecnico;

    @NotNull(message = "{status.obrigatorio}")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "{data.inicial.obrigatoria}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    private Date data_inicial;

    @NotNull(message = "{data.final.obrigatoria}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    private Date data_final;

    @NotNull(message = "{cliente.obrigatorio}")
    private ModelClientes cliente;

    @NotNull(message = "{tecnico.responsavel.obrigatorio}")
    @JsonProperty("tecnico_responsavel")
    private ModelTecnicoResponsavel tecnicoResponsavel;
}
