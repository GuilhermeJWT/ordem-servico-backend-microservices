package br.com.systemsgs.financeiroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tbl_fornecedores")
public class ModelFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @MongoId
    private Long id;
    private String nome;
    private String nomeFantasia;
    private String tipoPessoa;
    private String cnpj;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
}
