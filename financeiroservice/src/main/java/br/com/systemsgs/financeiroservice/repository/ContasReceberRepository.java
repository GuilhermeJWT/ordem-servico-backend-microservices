package br.com.systemsgs.financeiroservice.repository;

import br.com.systemsgs.financeiroservice.model.ModelContasReceber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasReceberRepository extends MongoRepository<ModelContasReceber, Long> {}
