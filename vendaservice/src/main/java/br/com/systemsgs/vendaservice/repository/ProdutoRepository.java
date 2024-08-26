package br.com.systemsgs.vendaservice.repository;

import br.com.systemsgs.vendaservice.model.ModelProdutos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ModelProdutos, Long> {

    @Query(value = "SELECT SUM(q.quantidade) FROM tbl_produtos q", nativeQuery = true)
    Optional<Integer> somaEstoqueAtual();
}
