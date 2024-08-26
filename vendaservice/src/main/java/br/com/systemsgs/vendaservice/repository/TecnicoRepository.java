package br.com.systemsgs.vendaservice.repository;

import br.com.systemsgs.vendaservice.model.ModelTecnicoResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<ModelTecnicoResponsavel, Long> {}
