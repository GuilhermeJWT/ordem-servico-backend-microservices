package br.com.systemsgs.cadastrosservice.service;

import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.List;

public interface EntidadesInterfaceService<T, ID>{

    T salvarEntidade(T entidade);

    Optional<T> pesquisaPorId(ID id);

    List<T> listarTodosRegistros();

    void deletarPorId(ID id);

    T atualizarEntidade(ID id, T entidade);

    Page<T> pesquisaPaginada(int page, int size);
}
