package br.com.systemsgs.financeiroservice.service.impl;

import br.com.systemsgs.financeiroservice.dto.request.ModelContasReceberDTO;
import br.com.systemsgs.financeiroservice.dto.response.ContasReceberResponse;
import br.com.systemsgs.financeiroservice.exception.erros.ContasPagarReceberNaoEncontradaException;
import br.com.systemsgs.financeiroservice.model.ModelContasReceber;
import br.com.systemsgs.financeiroservice.repository.ContasReceberRepository;
import br.com.systemsgs.financeiroservice.service.ContasReceberService;
import br.com.systemsgs.financeiroservice.util.UtilClientes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasReceberServiceImpl implements ContasReceberService {

    private final ContasReceberRepository contasReceberRepository;
    private final UtilClientes utilClientes;
    private final ModelMapper mapper;

    @Autowired
    public ContasReceberServiceImpl(ContasReceberRepository contasReceberRepository,
                                    UtilClientes utilClientes,
                                    ModelMapper mapper) {
        this.contasReceberRepository = contasReceberRepository;
        this.utilClientes = utilClientes;
        this.mapper = mapper;
    }

    @Override
    public ContasReceberResponse pesquisaPorId(Long id) {
        return converteEntidadeEmResponse(contasReceberRepository.findById(id).orElseThrow(() -> new ContasPagarReceberNaoEncontradaException()));
    }

    @Override
    public List<ContasReceberResponse> listarContasReceber() {
        return converteListaContasResponse(contasReceberRepository.findAll());
    }

    @Override
    public ContasReceberResponse cadastrarContasReceber(ModelContasReceberDTO modelContasReceberDTO) {
        ModelContasReceber modelContasReceber = new ModelContasReceber();

        var cliente = utilClientes.pesquisarClientePeloId(modelContasReceberDTO.getCodigoCliente());

        modelContasReceber.setData_vencimento(modelContasReceberDTO.getData_vencimento());
        modelContasReceber.setValor(modelContasReceberDTO.getValor());
        modelContasReceber.setObservacao(modelContasReceberDTO.getObservacao());
        modelContasReceber.setFormaPagamento(modelContasReceberDTO.getFormaPagamento());
        modelContasReceber.setStatusContasReceber(modelContasReceberDTO.getStatusContas());
        modelContasReceber.setCliente(cliente);

        return converteEntidadeEmResponse(contasReceberRepository.save(modelContasReceber));
    }

    @Override
    public ContasReceberResponse alterarContasReceber(Long id, ModelContasReceberDTO modelContasReceberDTO) {
        ModelContasReceber contaReceberPesquisada = contasReceberRepository.findById(modelContasReceberDTO.getId())
                .orElseThrow(() -> new ContasPagarReceberNaoEncontradaException());
        mapper.map(modelContasReceberDTO, ModelContasReceber.class);
        BeanUtils.copyProperties(modelContasReceberDTO, contaReceberPesquisada, "id");

        var contaReceberAtualizada = contasReceberRepository.save(contaReceberPesquisada);

        return converteEntidadeEmResponse(contaReceberAtualizada);
    }

    @Override
    public Page<ContasReceberResponse> listarContasReceberPaginada(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return contasReceberRepository.findAll(pageable).map(contas -> mapper.map(contas, ContasReceberResponse.class));
    }

    @Override
    public void deletarContasReceber(Long id) {
        contasReceberRepository.deleteById(id);
    }

    private List<ContasReceberResponse> converteListaContasResponse(List<ModelContasReceber> listModelsContasReceber){
        return listModelsContasReceber.stream().map(modelContasReceber -> mapper.map(modelContasReceber, ContasReceberResponse.class)).toList();
    }

    private ContasReceberResponse converteEntidadeEmResponse(ModelContasReceber modelContasReceber){
        return mapper.map(modelContasReceber, ContasReceberResponse.class);
    }
}
