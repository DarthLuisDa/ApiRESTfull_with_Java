package com.shopAll.ApiRESTfull.exceptions;

//Clases generales para toda la App. Código reutilizable. Practicamente es para agregar el mensaje
public class InvalidTareaDataException extends RuntimeException{
    public InvalidTareaDataException(String message) {
        super(message);
    }

}
