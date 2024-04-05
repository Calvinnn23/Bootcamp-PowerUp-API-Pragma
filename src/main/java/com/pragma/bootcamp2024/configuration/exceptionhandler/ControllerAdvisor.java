package com.pragma.bootcamp2024.configuration.exceptionhandler;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.*;
import com.pragma.bootcamp2024.configuration.Constants;
import com.pragma.bootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.bootcamp2024.domain.exception.StringOutOfBoundsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(String.format(Constants.EMPTY_FIELD_EXCEPTION_MESSAGE,
                exception.getMessage()), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(StringOutOfBoundsException.class)
    public ResponseEntity<ExceptionResponse> handleStringOutOfBoundsException(StringOutOfBoundsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(String.format(Constants.STRING_OUT_OF_BOUNDS_MESSAGE,
                exception.getMessage()), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerNoDataFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerElementNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(TechnologyAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handlerTechnologyAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(TechnologyNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerTechnologyNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.TECHNOLOGY_NOT_FOUND_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(CapacityAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handlerCapacityAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.CAPACITY_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(CapacityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerCapacityNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.CAPACITY_NOT_FOUND_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
}
