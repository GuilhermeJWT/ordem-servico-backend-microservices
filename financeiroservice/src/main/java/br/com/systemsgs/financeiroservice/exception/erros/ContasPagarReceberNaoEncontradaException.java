package br.com.systemsgs.financeiroservice.exception.erros;

public class ContasPagarReceberNaoEncontradaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ContasPagarReceberNaoEncontradaException(){
        super("Conta não Encontrada!");
    }
}
