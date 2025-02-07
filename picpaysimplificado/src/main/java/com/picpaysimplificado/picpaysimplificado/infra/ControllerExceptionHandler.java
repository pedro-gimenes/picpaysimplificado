package com.picpaysimplificado.picpaysimplificado.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.picpaysimplificado.picpaysimplificado.dto.ExceptionDto;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDto exceptionDto = new ExceptionDto("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDto);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(Exception exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage(), "506");
        return ResponseEntity.internalServerError().body(exceptionDto);
    }
}
