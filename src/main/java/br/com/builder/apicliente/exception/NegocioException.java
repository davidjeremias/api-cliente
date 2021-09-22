package br.com.builder.apicliente.exception;

public class NegocioException extends RuntimeException{

    public NegocioException(String msg){
        super(msg);
    }
}
