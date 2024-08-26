package br.com.systemsgs.cadastrosservice;

import br.com.systemsgs.cadastrosservice.enums.TipoPessoa;
import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import br.com.systemsgs.cadastrosservice.model.ModelEndereco;
import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import br.com.systemsgs.cadastrosservice.model.ModelTecnicoResponsavel;
import lombok.Getter;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

@ActiveProfiles(value = "test")
@Getter
public class ConfigDadosEstaticosEntidades {

    public List<String> mensagemErro(){
        List<String> msgErro = new ArrayList<>();

        String clienteNaoEncontrado = "Cliente não Encontrado!";
        String tecnicoNaoEncontrado = "Técnico Responsavel não Encontrado!";
        String fornecedorNaoEncontrado = "Fornecedor não Encontrado!";
        String camposDuplicados = "Campos já cadastrados na base de dados, Por Favor, Informe outros!";
        String metodoHttpNaoSuportado = "Tipo de solicitação HTTP incorreta, reveja qual o tipo correto: 'GET' 'POST' 'PUT' 'DELETE' ou outro!";

        msgErro.add(clienteNaoEncontrado);

        return msgErro;
    }

    public ModelFornecedor dadosFornecedores(){
        ModelFornecedor fornecedorResponse = new ModelFornecedor();

        fornecedorResponse.setId(1L);
        fornecedorResponse.setNome("Fornecedor Guilherme");
        fornecedorResponse.setNomeFantasia("Fornecedor Guilherme LTDA");
        fornecedorResponse.setTipoPessoa(TipoPessoa.PESSOA_FISICA);
        fornecedorResponse.setCnpj("58.472.837/0001-13"); // gerado no site: Gerador de CNPJ
        fornecedorResponse.setEndereco(dadosEndereco());

        return fornecedorResponse;
    }

    public ModelClientes dadosClientes(){
        ModelClientes clienteResponse = new ModelClientes();

        clienteResponse.setId(1L);
        clienteResponse.setNome("Guilherme Santos");
        clienteResponse.setCpf("819.945.180-73"); //gerado no site: GERADOR DE CPF
        clienteResponse.setCelular("19 99999999");
        clienteResponse.setEmail("guilherme@gmail.com");
        clienteResponse.setEndereco(dadosEndereco());

       return clienteResponse;
    }

    public ModelEndereco dadosEndereco(){
        ModelEndereco enderecoResponse = new ModelEndereco();

        enderecoResponse.setEndereco("Rua 1");
        enderecoResponse.setComplemento("Perto do Centro");
        enderecoResponse.setEstado("SP");
        enderecoResponse.setCidade("Caconde");
        enderecoResponse.setCep("13770-000");

        return enderecoResponse;
    }

    public ModelTecnicoResponsavel dadosTecnicoResponsavel(){
        ModelTecnicoResponsavel tecnicoResponse = new ModelTecnicoResponsavel();

        tecnicoResponse.setId(1L);
        tecnicoResponse.setNome("Guilherme Técnico");

        return tecnicoResponse;
    }
}
