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
@Document(collection = "tbl_clientes")
public class ModelClientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @MongoId
    private Long id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
}
