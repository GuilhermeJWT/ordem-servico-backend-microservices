package br.com.systemsgs.osservice.service.impl;

import br.com.systemsgs.osservice.dto.request.ModelOrdemServicoDTO;
import br.com.systemsgs.osservice.exception.errors.OrdemServicoNaoEncontradoException;
import br.com.systemsgs.osservice.model.ModelClientes;
import br.com.systemsgs.osservice.model.ModelOrdemServico;
import br.com.systemsgs.osservice.repository.OrdemServicoRepository;
import br.com.systemsgs.osservice.service.OrdemServicoService;
import br.com.systemsgs.osservice.util.UtilClientes;
import br.com.systemsgs.osservice.util.UtilOrdemServico;
import br.com.systemsgs.osservice.util.UtilTecnicoResponsavel;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final UtilOrdemServico utilOrdemServico;
    private final UtilClientes utilClientes;
    private final ModelMapper mapper;
    private final UtilTecnicoResponsavel utilTecnicoResponsavel;

    @Autowired
    public OrdemServicoServiceImpl(OrdemServicoRepository ordemServicoRepository,
                                   UtilOrdemServico utilOrdemServico,
                                   UtilClientes utilClientes,
                                   ModelMapper mapper,
                                   UtilTecnicoResponsavel utilTecnicoResponsavel) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.utilOrdemServico = utilOrdemServico;
        this.utilClientes = utilClientes;
        this.mapper = mapper;
        this.utilTecnicoResponsavel = utilTecnicoResponsavel;
    }

    @Override
    public ModelOrdemServico pesquisaPorId(Long id) {
        return ordemServicoRepository.findById(id).orElseThrow(() -> new OrdemServicoNaoEncontradoException());
    }

    @Override
    public List<ModelOrdemServico> listarOS() {
        return ordemServicoRepository.findAll();
    }

    @Transactional
    @Override
    public ModelOrdemServico salvarOS(ModelOrdemServicoDTO modelOrdemServicoDTO) {
         validaCliente(modelOrdemServicoDTO);
         utilTecnicoResponsavel.validaTecnicoExistente(modelOrdemServicoDTO);

        return ordemServicoRepository.save(mapper.map(modelOrdemServicoDTO, ModelOrdemServico.class));
    }

    @Override
    public void deletarOS(Long id) {
        ordemServicoRepository.deleteById(id);
    }

    @Override
    public ModelOrdemServico atualizarOS(Long id, ModelOrdemServicoDTO modelOrdemServicoDTO) {
        ModelOrdemServico osPesquisada = utilOrdemServico.pesquisaOsPorId(id);
        validaCliente(modelOrdemServicoDTO);
        utilTecnicoResponsavel.validaTecnicoExistente(modelOrdemServicoDTO);

        mapper.map(modelOrdemServicoDTO, ModelClientes.class);

        return ordemServicoRepository.save(osPesquisada);
    }

    public ModelOrdemServicoDTO validaCliente(ModelOrdemServicoDTO modelOrdemServicoDTO){
        ModelClientes pesquisaCliente = utilClientes.pesquisarClientePeloId(modelOrdemServicoDTO.getCliente().getId());

        modelOrdemServicoDTO.getCliente().setNome(pesquisaCliente.getNome());
        modelOrdemServicoDTO.getCliente().setCpf(pesquisaCliente.getCpf());
        modelOrdemServicoDTO.getCliente().setCelular(pesquisaCliente.getCelular());
        modelOrdemServicoDTO.getCliente().setEmail(pesquisaCliente.getEmail());
        modelOrdemServicoDTO.getCliente().setEndereco(pesquisaCliente.getEndereco());

        return modelOrdemServicoDTO;
    }
}
