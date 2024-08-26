package br.com.systemsgs.osservice.exception.errors;

public class ErroInternoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ErroInternoException(){
        super("Erro Interno no Servidor, Contate a equipe de Desenvolvimento.");
    }
}
