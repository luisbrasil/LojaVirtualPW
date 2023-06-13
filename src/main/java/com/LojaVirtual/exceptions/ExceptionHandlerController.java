package com.LojaVirtual.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.LojaVirtual.exceptions.models.ObjectValidationError;
import com.LojaVirtual.exceptions.models.ResponseValidationError;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        
        System.out.println(ex.getMostSpecificCause());
        if (ex.getMostSpecificCause().toString().contains("FOREIGN KEY")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
            body("Não foi possível excluir, houve uma violação de chave estrangeira.");
        } else if (ex.getMostSpecificCause().toString().contains("PRIMARY KEY")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
            body("Não foi possível excluir, houve uma violação de chave primária detectada.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
            body("Não foi possível excluir, houve uma violação de integridade detectada.");
        }
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseValidationError> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<ObjectValidationError> errors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors){
            ObjectValidationError validationError = new ObjectValidationError(fieldError.getDefaultMessage(), fieldError.getField(),
            fieldError.getRejectedValue());
            errors.add(validationError);
        }

        ResponseValidationError errorResponse = new ResponseValidationError(
            "Erro de validação", 400, "Bad Request", ex.getObjectName(), errors
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

