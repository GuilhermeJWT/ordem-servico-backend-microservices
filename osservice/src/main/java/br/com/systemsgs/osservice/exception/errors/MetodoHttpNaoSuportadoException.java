package br.com.systemsgs.osservice.exception.errors;

public class MetodoHttpNaoSuportadoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MetodoHttpNaoSuportadoException() {
        super("Tipo de solicitação HTTP incorreta, reveja qual o tipo correto: 'GET' 'POST' 'PUT' 'DELETE' ou outro!");
    }
}
