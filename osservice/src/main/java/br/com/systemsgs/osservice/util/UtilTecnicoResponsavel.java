package br.com.systemsgs.osservice.util;

import br.com.systemsgs.osservice.dto.request.ModelOrdemServicoDTO;
import br.com.systemsgs.osservice.exception.errors.TecnicoResponsavelNaoEncontradoException;
import br.com.systemsgs.osservice.model.ModelTecnicoResponsavel;
import br.com.systemsgs.osservice.repository.TecnicoRepository;
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

    public ModelOrdemServicoDTO validaTecnicoExistente(ModelOrdemServicoDTO modelOrdemServicoDTO){
        ModelTecnicoResponsavel pesquisaTecnico = pesquisarTecnicoPeloId(modelOrdemServicoDTO.getTecnicoResponsavel().getId());
        modelOrdemServicoDTO.getTecnicoResponsavel().setNome(pesquisaTecnico.getNome());

        return modelOrdemServicoDTO;
    }
}
