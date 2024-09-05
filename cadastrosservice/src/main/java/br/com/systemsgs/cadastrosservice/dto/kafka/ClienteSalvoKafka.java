package br.com.systemsgs.cadastrosservice.dto.kafka;

import br.com.systemsgs.cadastrosservice.enums.TipoAlteracaoCadastros;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSalvoKafka {

    private Long id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private TipoAlteracaoCadastros tipoAlteracaoCadastros;

}
