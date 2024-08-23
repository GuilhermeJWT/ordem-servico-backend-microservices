package br.com.systemsgs.cadastrosservice.service.impl;

import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorImplService implements EntidadesInterfaceService<ModelFornecedor, Long> {

    @Override
    public ModelFornecedor salvarEntidade(ModelFornecedor entidade) {
        return null;
    }

    @Override
    public Optional<ModelFornecedor> pesquisaPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ModelFornecedor> listarTodosRegistros() {
        return List.of();
    }

    @Override
    public void deletarPorId(Long id) {

    }

    @Override
    public ModelFornecedor atualizarEntidade(Long id, ModelFornecedor entidade) {
        return null;
    }

    @Override
    public Page<ModelFornecedor> pesquisaPaginada(Pageable pageable) {
        return null;
    }
}
