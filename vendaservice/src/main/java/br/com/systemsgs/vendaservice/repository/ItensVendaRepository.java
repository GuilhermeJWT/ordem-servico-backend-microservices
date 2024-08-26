package br.com.systemsgs.vendaservice.repository;

import br.com.systemsgs.vendaservice.model.ModelItensVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensVendaRepository extends JpaRepository<ModelItensVendas, Long> {}
