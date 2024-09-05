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
        return new ClienteSalvoKafka(
                clienteSalvo.getId(),
                clienteSalvo.getNome(),
                clienteSalvo.getCpf(),
                clienteSalvo.getCelular(),
                clienteSalvo.getEmail(),
                clienteSalvo.getEndereco().getEndereco(),
                clienteSalvo.getEndereco().getComplemento(),
                clienteSalvo.getEndereco().getCidade(),
                clienteSalvo.getEndereco().getEstado(),
                clienteSalvo.getEndereco().getCep(),
                TipoAlteracaoCadastros.CADASTRO);
    }
}
