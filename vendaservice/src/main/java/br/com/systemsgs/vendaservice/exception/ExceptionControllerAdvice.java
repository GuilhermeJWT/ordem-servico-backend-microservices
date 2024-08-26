package br.com.systemsgs.vendaservice.exception;

import br.com.systemsgs.vendaservice.exception.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiRestErrors httpMessageNotReadableException(){
        return new ApiRestErrors(new PayloadInexistenteException().getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiRestErrors handlerMethodNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> errors =  methodArgumentNotValidException.getBindingResult().getAllErrors()
                .stream().map(erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiRestErrors(errors);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiRestErrors internalServerErroException(){
        return new ApiRestErrors(new ErroInternoException().getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiRestErrors metodoHttpNaoSuportadoException(){
        return new ApiRestErrors(new MetodoHttpNaoSuportadoException().getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiRestErrors endpointNaoEncontradoException(){
        return new ApiRestErrors(new EndpointNaoEncontradoException().getMessage());
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiRestErrors produtoNaoEncontradoException(ProdutoNaoEncontradoException produtoNaoEncontradoException){
        return new ApiRestErrors(produtoNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiRestErrors clienteNaoEncontradoException(ClienteNaoEncontradoException clienteNaoEncontradoException){
        return new ApiRestErrors(clienteNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(TecnicoResponsavelNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiRestErrors tecnicoNaoEncontradoException(TecnicoResponsavelNaoEncontradoException tecnicoResponsavelNaoEncontradoException){
        return new ApiRestErrors(tecnicoResponsavelNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(VendaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiRestErrors vendaNaoEncontradaException(VendaNaoEncontradaException vendaNaoEncontradaException){
        return new ApiRestErrors(vendaNaoEncontradaException.getMessage());
    }
}
