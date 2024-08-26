package br.com.systemsgs.osservice.repository;

import br.com.systemsgs.osservice.model.ModelClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ModelClientes, Long> {}
