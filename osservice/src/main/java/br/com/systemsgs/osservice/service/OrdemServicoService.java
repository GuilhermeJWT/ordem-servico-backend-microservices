package br.com.systemsgs.osservice.service;

import br.com.systemsgs.osservice.dto.request.ModelOrdemServicoDTO;
import br.com.systemsgs.osservice.model.ModelOrdemServico;

import java.util.List;

public interface OrdemServicoService {

    ModelOrdemServico pesquisaPorId(Long id);

    List<ModelOrdemServico> listarOS();

    ModelOrdemServico salvarOS(ModelOrdemServicoDTO modelOrdemServicoDTO);

    void deletarOS(Long id);

    ModelOrdemServico atualizarOS(Long id, ModelOrdemServicoDTO modelOrdemServicoDTO);
}
