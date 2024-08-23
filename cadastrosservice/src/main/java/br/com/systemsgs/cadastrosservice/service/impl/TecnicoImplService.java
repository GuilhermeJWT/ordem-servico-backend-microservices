package br.com.systemsgs.cadastrosservice.service.impl;

import br.com.systemsgs.cadastrosservice.model.ModelTecnicoResponsavel;
import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoImplService implements EntidadesInterfaceService<ModelTecnicoResponsavel, Long> {

    @Override
    public ModelTecnicoResponsavel salvarEntidade(ModelTecnicoResponsavel entidade) {
        return null;
    }

    @Override
    public Optional<ModelTecnicoResponsavel> pesquisaPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ModelTecnicoResponsavel> listarTodosRegistros() {
        return List.of();
    }

    @Override
    public void deletarPorId(Long id) {

    }

    @Override
    public ModelTecnicoResponsavel atualizarEntidade(Long id, ModelTecnicoResponsavel entidade) {
        return null;
    }

    @Override
    public Page<ModelTecnicoResponsavel> pesquisaPaginada(Pageable pageable) {
        return null;
    }
}
