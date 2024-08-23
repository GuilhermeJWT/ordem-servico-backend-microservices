package br.com.systemsgs.cadastrosservice.repository;

import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ModelClientes, Long> {}
