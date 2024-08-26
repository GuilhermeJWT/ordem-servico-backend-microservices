package br.com.systemsgs.vendaservice.exception.errors;

public class VendaNaoEncontradaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public VendaNaoEncontradaException() {
        super("Venda não Encontrada!");
    }

}
