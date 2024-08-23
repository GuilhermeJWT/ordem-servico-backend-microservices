package br.com.systemsgs.cadastrosservice.service;

import br.com.systemsgs.cadastrosservice.dto.request.ModelFornecedorDTO;
import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FornecedorService {

    ModelFornecedor pesquisaPorId(Long id);

    List<ModelFornecedor> listarFornecedores();

    ModelFornecedor salvarFornecedor(ModelFornecedorDTO modelFornecedorDTO);

    void deletarFornecedor(Long id);

    ModelFornecedor updateFornecedor(Long id, ModelFornecedorDTO modelFornecedorDTO);

    Page<ModelFornecedorDTO> listarFornecedoresPaginados(int page, int size);
}
