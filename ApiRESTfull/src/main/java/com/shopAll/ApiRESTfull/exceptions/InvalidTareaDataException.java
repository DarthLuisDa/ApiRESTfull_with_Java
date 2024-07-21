package com.shopAll.ApiRESTfull.exceptions;

//Clases generales para toda la App. Código reutilizable. Practicamente es para agregar el mensaje

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class InvalidTareaDataException extends RuntimeException{
    private String codigo;
    private HttpStatus httpStatus;

    private BindingResult bindingResult;

    public InvalidTareaDataException(String mensaje, String codigo, HttpStatus httpStatus, BindingResult bindingResult){
        super(mensaje);
        this.codigo = codigo;
        this.httpStatus = httpStatus;
        this.bindingResult = bindingResult;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}

