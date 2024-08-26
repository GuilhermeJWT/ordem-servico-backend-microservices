package br.com.systemsgs.vendaservice.repository;

import br.com.systemsgs.vendaservice.model.ModelClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ModelClientes, Long> {}
