package br.com.systemsgs.financeiroservice.repository;

import br.com.systemsgs.financeiroservice.model.ModelContasPagar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarRepository extends MongoRepository<ModelContasPagar, Long> {}
