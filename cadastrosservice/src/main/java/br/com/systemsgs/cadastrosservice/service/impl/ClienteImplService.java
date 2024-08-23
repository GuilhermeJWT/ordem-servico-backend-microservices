package br.com.systemsgs.cadastrosservice.service.impl;

import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImplService implements EntidadesInterfaceService<ModelClientes, Long> {

    @Override
    public ModelClientes salvarEntidade(ModelClientes entidade) {
        return null;
    }

    @Override
    public Optional<ModelClientes> pesquisaPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ModelClientes> listarTodosRegistros() {
        return List.of();
    }

    @Override
    public void deletarPorId(Long id) {

    }

    @Override
    public ModelClientes atualizarEntidade(Long id, ModelClientes entidade) {
        return null;
    }

    @Override
    public Page<ModelClientes> pesquisaPaginada(Pageable pageable) {
        return null;
    }
}
