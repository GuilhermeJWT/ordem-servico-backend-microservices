package br.com.systemsgs.cadastrosservice.util;

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
}
