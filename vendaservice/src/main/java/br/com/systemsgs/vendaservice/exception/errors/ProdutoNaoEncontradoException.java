package br.com.systemsgs.vendaservice.exception.errors;

public class ProdutoNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException() {
        super("Produto não Encontrado!");
    }
}
