package br.com.systemsgs.cadastrosservice.service;

import br.com.systemsgs.cadastrosservice.dto.request.ModelClientesDTO;
import br.com.systemsgs.cadastrosservice.dto.response.ClienteResponse;
import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClienteService {

    ModelClientes pesquisaPorId(Long id);

    List<ModelClientes> listarClientes();

    ModelClientes salvarClientes(ModelClientesDTO modelClientesDTO);

    void deletarCliente(Long id);

    ModelClientes updateClientes(Long id, ModelClientesDTO modelClientesDTO);

    Page<ClienteResponse> listarClientesPaginado(int page, int size);

}
