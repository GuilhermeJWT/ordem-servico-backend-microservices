package br.com.systemsgs.financeiroservice.exception.erros;

public class PayloadInexistenteException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PayloadInexistenteException() {
        super("Payload da Requisição Inexistente, informe os campos Válidos.");
    }
}
