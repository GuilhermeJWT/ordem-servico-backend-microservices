package br.com.systemsgs.osservice.util;

import br.com.systemsgs.osservice.exception.errors.OrdemServicoNaoEncontradoException;
import br.com.systemsgs.osservice.model.ModelOrdemServico;
import br.com.systemsgs.osservice.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UtilOrdemServico {

    private final OrdemServicoRepository ordemServicoRepository;

    @Autowired
    public UtilOrdemServico(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public ModelOrdemServico pesquisaOsPorId(Long id){
        return ordemServicoRepository.findById(id).orElseThrow(() -> new OrdemServicoNaoEncontradoException());
    }

    public Optional<Integer> quantidadeOsRealizadas(){
        return ordemServicoRepository.quantidadeOsRealizadas();
    }

    public Optional<Integer> quantidadeOsStatusEmAndamento(){
        return ordemServicoRepository.quantidadeOsEmAndamento();
    }
}
