package br.com.systemsgs.osservice.util;

import br.com.systemsgs.osservice.exception.errors.ClienteNaoEncontradoException;
import br.com.systemsgs.osservice.model.ModelClientes;
import br.com.systemsgs.osservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilClientes {

    private final ClienteRepository clienteRepository;

    @Autowired
    public UtilClientes(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ModelClientes pesquisarClientePeloId(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException());
    }
}
