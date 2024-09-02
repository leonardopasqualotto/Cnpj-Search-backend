package com.example.cnpjsearch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.cnpjsearch.exception.EstabelecimentoNotFoudException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(EstabelecimentoNotFoudException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(EstabelecimentoNotFoudException e){
        return e.getMessage();
        
    }
}
