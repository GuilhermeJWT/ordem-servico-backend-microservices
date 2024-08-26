package br.com.systemsgs.vendaservice.util;

import br.com.systemsgs.vendaservice.dto.request.ModelVendasDTO;
import br.com.systemsgs.vendaservice.exception.errors.ProdutoNaoEncontradoException;
import br.com.systemsgs.vendaservice.model.ModelProdutos;
import br.com.systemsgs.vendaservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UtilProdutos {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public UtilProdutos(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void baixaEstoqueProdutos(ModelVendasDTO modelVendasDTO){
        var produtosVenda = produtoRepository.findAllById(modelVendasDTO.getItens().stream()
                .map(idsProdutos -> idsProdutos.getId_produto()).collect(Collectors.toList()));
        var quantidades = modelVendasDTO.getItens().stream()
                .map(quantidadeProdutos -> quantidadeProdutos.getQuantidade()).collect(Collectors.toList());

        ListIterator<ModelProdutos> iterator = produtosVenda.listIterator();
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            ModelProdutos produto = iterator.next();
            Integer quantidade = quantidades.get(index);

            produto.setQuantidade(produto.getQuantidade() - quantidade);
            produtoRepository.save(produto);
        }
    }

    public ModelProdutos pesquisaProdutoPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException());
    }

    public List<ModelProdutos> pesquisaListaProdutosPorIds(List<Long> id){
        var pesquisaProduto = produtoRepository.findAllById(id);

        if(pesquisaProduto.isEmpty()){
            throw new ProdutoNaoEncontradoException();
        }

        return pesquisaProduto.stream().toList();
    }

    public List<String> pesquisaDescricaoProdutosPorIds(List<Long> id){

        var pesquisaProdutos = produtoRepository.findAllById(id);

        if(pesquisaProdutos.isEmpty()){
            throw new ProdutoNaoEncontradoException();
        }

        return pesquisaProdutos.stream().map(p -> p.getDescricao()).collect(Collectors.toList());
    }

    public Optional<Integer> somaEstoqueAtualProdutos(){
        return produtoRepository.somaEstoqueAtual();
    }
}
