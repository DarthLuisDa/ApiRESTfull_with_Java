package com.shopAll.ApiRESTfull.controllers;

import com.shopAll.ApiRESTfull.exceptions.InvalidTareaDataException;
import com.shopAll.ApiRESTfull.exceptions.TareaNotFoundException;
import com.shopAll.ApiRESTfull.utils.ModelError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TareaControllerAdvice {
    @ExceptionHandler(InvalidTareaDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTareaDataException(InvalidTareaDataException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Invalid Tarea Data Exception");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TareaNotFoundException.class)
    public ResponseEntity<ModelError> elementoNoEncontrado(TareaNotFoundException notFoundExeption){
        ModelError modelError = new ModelError(notFoundExeption.getCodigo(), notFoundExeption.getMessage(),null);

        return new ResponseEntity<>(modelError, notFoundExeption.getHttpStatus());
    }

    /*
    //Otra forma de manejar el error TareaNotFoundException
    @ExceptionHandler(TareaNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTareaNotFoundException(TareaNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Tarea Not Found");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
*/
}
