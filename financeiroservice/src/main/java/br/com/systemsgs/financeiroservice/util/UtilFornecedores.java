package br.com.systemsgs.financeiroservice.util;

import br.com.systemsgs.financeiroservice.exception.erros.FornecedorNaoEncontradoException;
import br.com.systemsgs.financeiroservice.model.ModelFornecedor;
import br.com.systemsgs.financeiroservice.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilFornecedores {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public UtilFornecedores(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public ModelFornecedor pesquisarFornecedorPeloId(Long id){
        return fornecedorRepository.findById(id).orElseThrow(() -> new FornecedorNaoEncontradoException());
    }
}
