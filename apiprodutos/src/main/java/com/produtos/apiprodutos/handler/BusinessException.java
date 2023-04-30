package com.produtos.apiprodutos.handler;

public class BusinessException extends RuntimeException {
    public  BusinessException(String mensagem){
        super(mensagem);
    }
    public BusinessException(String mensagwm, Object ... params){
        super(String.format(mensagwm,params));
    }
}
