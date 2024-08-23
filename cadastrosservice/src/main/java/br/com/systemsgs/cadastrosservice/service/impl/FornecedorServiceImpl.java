package br.com.systemsgs.cadastrosservice.service.impl;

import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import br.com.systemsgs.cadastrosservice.repository.FornecedoresRepository;
import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements EntidadesInterfaceService<ModelFornecedor, Long> {

    private final FornecedoresRepository fornecedoresRepository;
    private final ModelMapper mapper;

    @Autowired
    public FornecedorServiceImpl(FornecedoresRepository fornecedoresRepository, ModelMapper mapper) {
        this.fornecedoresRepository = fornecedoresRepository;
        this.mapper = mapper;
    }

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
    public Page<ModelFornecedor> pesquisaPaginada(int page, int size) {
        return null;
    }
}
