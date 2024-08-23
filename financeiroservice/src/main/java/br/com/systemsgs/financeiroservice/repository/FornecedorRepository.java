package br.com.systemsgs.financeiroservice.repository;

import br.com.systemsgs.financeiroservice.model.ModelFornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<ModelFornecedor, Long> {}
