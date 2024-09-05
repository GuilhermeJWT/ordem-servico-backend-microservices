package br.com.systemsgs.cadastrosservice.service.impl;

import br.com.systemsgs.cadastrosservice.dto.request.ModelClientesDTO;
import br.com.systemsgs.cadastrosservice.dto.response.ClienteResponse;
import br.com.systemsgs.cadastrosservice.exception.erros.ClienteNaoEncontradoException;
import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import br.com.systemsgs.cadastrosservice.model.ModelEndereco;
import br.com.systemsgs.cadastrosservice.repository.ClienteRepository;
import br.com.systemsgs.cadastrosservice.service.ClienteService;
import br.com.systemsgs.cadastrosservice.util.UtilClientes;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.systemsgs.cadastrosservice.config.KafkaProducerConfig.TOPIC_CLIENTES;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final UtilClientes utilClientes;
    private final ModelMapper mapper;
    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, UtilClientes utilClientes, ModelMapper mapper, KafkaTemplate kafkaTemplate) {
        this.clienteRepository = clienteRepository;
        this.utilClientes = utilClientes;
        this.mapper = mapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public ModelClientes pesquisaPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException());
    }

    @Override
    public List<ModelClientes> listarClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    @Override
    public ModelClientes salvarClientes(ModelClientesDTO modelClientesDTO) {
        ModelClientes modelClientes = new ModelClientes();
        ModelEndereco modelEndereco = new ModelEndereco();

        modelEndereco.setEndereco(modelClientesDTO.getEndereco());
        modelEndereco.setComplemento(modelClientesDTO.getComplemento());
        modelEndereco.setCidade(modelClientesDTO.getCidade());
        modelEndereco.setEstado(modelClientesDTO.getEstado());
        modelEndereco.setCep(modelClientesDTO.getCep());
        modelClientes.setNome(modelClientesDTO.getNome());
        modelClientes.setCpf(modelClientesDTO.getCpf());
        modelClientes.setCelular(modelClientesDTO.getCelular());
        modelClientes.setEmail(modelClientesDTO.getEmail());
        modelClientes.setEndereco(modelEndereco);

        ModelClientes clienteSalvo = clienteRepository.save(modelClientes);
        kafkaTemplate.send(TOPIC_CLIENTES, utilClientes.converteClienteSalvoKafka(clienteSalvo));

        return clienteSalvo;
    }

    @Override
    public Page<ClienteResponse> listarClientesPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return clienteRepository.findAll(pageable).map(clientes -> mapper.map(clientes, ClienteResponse.class));
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ModelClientes updateClientes(Long id, ModelClientesDTO modelClientesDTO) {
        ModelClientes clientePesquisado = utilClientes.pesquisarClientePeloId(id);
        mapper.map(modelClientesDTO, ModelClientes.class);
        BeanUtils.copyProperties(modelClientesDTO, clientePesquisado, "id");

        return clienteRepository.save(clientePesquisado);
    }
}
