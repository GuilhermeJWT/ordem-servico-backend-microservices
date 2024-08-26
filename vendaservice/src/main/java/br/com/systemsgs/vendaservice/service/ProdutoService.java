package br.com.systemsgs.vendaservice.service;

import br.com.systemsgs.vendaservice.dto.request.ModelProdutosDTO;
import br.com.systemsgs.vendaservice.model.ModelProdutos;

import java.util.List;

public interface ProdutoService {

    ModelProdutos pesquisaPorId(Long id);

    List<ModelProdutos> listarProdutos();

    ModelProdutos salvarProdutos(ModelProdutosDTO modelProdutosDTO);

    void deletarProduto(Long id);

    ModelProdutos atualizarProduto(Long id, ModelProdutosDTO modelProdutosDTO);

}
