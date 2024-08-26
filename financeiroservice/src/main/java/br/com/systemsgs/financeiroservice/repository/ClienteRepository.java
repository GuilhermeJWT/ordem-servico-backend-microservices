package br.com.systemsgs.financeiroservice.repository;

import br.com.systemsgs.financeiroservice.model.ModelClientes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<ModelClientes, Long> {}
