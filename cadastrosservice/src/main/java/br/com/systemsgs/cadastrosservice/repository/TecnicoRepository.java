package br.com.systemsgs.cadastrosservice.repository;

import br.com.systemsgs.cadastrosservice.model.ModelTecnicoResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<ModelTecnicoResponsavel, Long> {}
