package br.com.systemsgs.cadastrosservice.dto.kafka;

import br.com.systemsgs.cadastrosservice.enums.TipoAlteracaoCadastros;
import br.com.systemsgs.cadastrosservice.enums.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorSalvoKafka {

    private Long id;
    private String nome;
    private String nomeFantasia;
    private TipoPessoa tipoPessoa;
    private String cnpj;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private TipoAlteracaoCadastros tipoAlteracaoCadastros;

}
