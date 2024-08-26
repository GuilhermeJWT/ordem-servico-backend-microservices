package br.com.systemsgs.vendaservice.exception.errors;

public class ClienteNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoException() {
        super("Cliente não Encontrado!");
    }
}
