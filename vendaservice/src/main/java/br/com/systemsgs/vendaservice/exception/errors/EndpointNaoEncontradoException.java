package br.com.systemsgs.vendaservice.exception.errors;

public class EndpointNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EndpointNaoEncontradoException() {
        super("URL do Endpoint Inválido! Por Favor, confira se o endereço correto da Requisição!");
    }
}
