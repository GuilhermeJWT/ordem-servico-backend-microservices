package br.com.systemsgs.cadastrosservice.exception.erros;

public class FornecedorNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FornecedorNaoEncontradoException() {
        super("Fornecedor não Encontrado!");
    }

}
