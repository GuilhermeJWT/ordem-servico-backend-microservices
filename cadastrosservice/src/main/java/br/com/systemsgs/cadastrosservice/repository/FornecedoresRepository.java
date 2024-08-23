package br.com.systemsgs.cadastrosservice.repository;

import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<ModelFornecedor, Long> {}
