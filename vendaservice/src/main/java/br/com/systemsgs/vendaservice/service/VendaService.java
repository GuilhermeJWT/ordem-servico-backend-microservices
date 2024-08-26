package br.com.systemsgs.vendaservice.service;

import br.com.systemsgs.vendaservice.dto.request.ModelVendasDTO;
import br.com.systemsgs.vendaservice.dto.response.VendasResponse;
import br.com.systemsgs.vendaservice.model.ModelVendas;

public interface VendaService {

    ModelVendas salvarVenda(ModelVendasDTO modelVendasDTO);

    VendasResponse pesquisaVendaPorId(Long id);

}
