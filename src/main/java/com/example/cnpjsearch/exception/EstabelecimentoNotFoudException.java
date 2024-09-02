package com.example.cnpjsearch.exception;

public class EstabelecimentoNotFoudException extends RuntimeException {
    public EstabelecimentoNotFoudException(String id){
        super("Estabelecimento não encontrado com o cnpj "+ id);
    }
}
