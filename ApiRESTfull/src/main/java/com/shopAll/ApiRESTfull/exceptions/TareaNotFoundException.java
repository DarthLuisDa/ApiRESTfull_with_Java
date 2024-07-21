package com.shopAll.ApiRESTfull.exceptions;

//Clases generales para toda la App. Código reutilizable. Practicamente es para agregar el mensaje

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)

public class TareaNotFoundException extends RuntimeException {
    private String codigo;
    private HttpStatus httpStatus;
    public TareaNotFoundException(String mensaje, String codigo, HttpStatus httpStatus) {
        super(mensaje);
        this.codigo = codigo;
        this.httpStatus = httpStatus;
    }

    //GETTERS ySETTERS para manejar la clase TareaNotFoundException
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

}



