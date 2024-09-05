package br.com.systemsgs.cadastrosservice.util;

import br.com.systemsgs.cadastrosservice.dto.kafka.ClienteSalvoKafka;
import br.com.systemsgs.cadastrosservice.enums.TipoAlteracaoCadastros;
import br.com.systemsgs.cadastrosservice.exception.erros.ClienteNaoEncontradoException;
import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import br.com.systemsgs.cadastrosservice.repository.ClienteRepository;
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

    public ClienteSalvoKafka converteClienteSalvoKafka(ModelClientes clienteSalvo) {
        ClienteSalvoKafka clienteKafka = new ClienteSalvoKafka();

        clienteKafka.setId(clienteSalvo.getId());
        clienteKafka.setNome(clienteSalvo.getNome());
        clienteKafka.setCpf(clienteSalvo.getCpf());
        clienteKafka.setCelular(clienteSalvo.getCelular());
        clienteKafka.setEmail(clienteSalvo.getEmail());
        clienteKafka.setEndereco(clienteSalvo.getEndereco().getEndereco());
        clienteKafka.setComplemento(clienteSalvo.getEndereco().getComplemento());
        clienteKafka.setCidade(clienteSalvo.getEndereco().getCidade());
        clienteKafka.setEstado(clienteSalvo.getEndereco().getEstado());
        clienteKafka.setCep(clienteSalvo.getEndereco().getCep());
        clienteKafka.setTipoAlteracaoCadastros(TipoAlteracaoCadastros.CADASTRO);

        return clienteKafka;
    }
}
