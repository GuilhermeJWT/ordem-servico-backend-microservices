package br.com.systemsgs.osservice.exception.errors;

public class OrdemServicoNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public OrdemServicoNaoEncontradoException() {
        super("Ordem de Serviço não Encontrada!");
    }
}
