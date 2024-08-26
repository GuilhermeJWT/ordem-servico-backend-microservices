package br.com.systemsgs.osservice.exception.errors;

public class TecnicoResponsavelNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TecnicoResponsavelNaoEncontradoException() {
        super("Técnico Responsavel não Encontrado!");
    }
}
