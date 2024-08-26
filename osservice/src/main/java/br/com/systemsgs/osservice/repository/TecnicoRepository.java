package br.com.systemsgs.osservice.repository;

import br.com.systemsgs.osservice.model.ModelTecnicoResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<ModelTecnicoResponsavel, Long> {}
