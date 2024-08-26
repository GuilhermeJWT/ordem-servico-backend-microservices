package br.com.systemsgs.vendaservice.exception.errors;

public class PayloadInexistenteException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PayloadInexistenteException() {
        super("Payload da Requisição Inexistente, informe os campos Válidos.");
    }

}
