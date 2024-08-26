package br.com.systemsgs.financeiroservice.service;

import br.com.systemsgs.financeiroservice.dto.request.ModelContasPagarDTO;
import br.com.systemsgs.financeiroservice.dto.response.ContasPagarResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContasPagarService {

    ContasPagarResponse pesquisaPorId(Long id);

    List<ContasPagarResponse> listarContasPagar();

    ContasPagarResponse cadastrarContasPagar(ModelContasPagarDTO modelContasPagarDTO);

    void deletarContasPagar(Long id);

    ContasPagarResponse alterarContasPagar(Long id, ModelContasPagarDTO modelContasPagarDTO);

    Page<ContasPagarResponse> listarContasPagarPaginada(int page, int size);
}
