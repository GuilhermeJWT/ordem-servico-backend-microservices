package br.com.systemsgs.cadastrosservice.util;

import br.com.systemsgs.cadastrosservice.dto.kafka.FornecedorSalvoKafka;
import br.com.systemsgs.cadastrosservice.enums.TipoAlteracaoCadastros;
import br.com.systemsgs.cadastrosservice.exception.erros.FornecedorNaoEncontradoException;
import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import br.com.systemsgs.cadastrosservice.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilFornecedores {

    private final FornecedoresRepository fornecedoresRepository;

    @Autowired
    public UtilFornecedores(FornecedoresRepository fornecedoresRepository) {
        this.fornecedoresRepository = fornecedoresRepository;
    }

    public ModelFornecedor pesquisarFornecedorPeloId(Long id){
        return fornecedoresRepository.findById(id).orElseThrow(() -> new FornecedorNaoEncontradoException());
    }

    public FornecedorSalvoKafka converteFornecedorSalvoKafka(ModelFornecedor fornecedorSalvo) {
       return new FornecedorSalvoKafka(
               fornecedorSalvo.getId(),
               fornecedorSalvo.getNome(),
               fornecedorSalvo.getNomeFantasia(),
               fornecedorSalvo.getTipoPessoa(),
               fornecedorSalvo.getCnpj(),
               fornecedorSalvo.getEndereco().getEndereco(),
               fornecedorSalvo.getEndereco().getComplemento(),
               fornecedorSalvo.getEndereco().getCidade(),
               fornecedorSalvo.getEndereco().getEstado(),
               fornecedorSalvo.getEndereco().getCep(),
               TipoAlteracaoCadastros.CADASTRO);
    }
}
