package br.com.systemsgs.vendaservice.util;

import br.com.systemsgs.vendaservice.exception.errors.TecnicoResponsavelNaoEncontradoException;
import br.com.systemsgs.vendaservice.model.ModelTecnicoResponsavel;
import br.com.systemsgs.vendaservice.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilTecnicoResponsavel {

    private final TecnicoRepository tecnicoRepository;

    @Autowired
    public UtilTecnicoResponsavel(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public ModelTecnicoResponsavel pesquisarTecnicoPeloId(Long id){
        return tecnicoRepository.findById(id).orElseThrow(() -> new TecnicoResponsavelNaoEncontradoException());
    }
}
