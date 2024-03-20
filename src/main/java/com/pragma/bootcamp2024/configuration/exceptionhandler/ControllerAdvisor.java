package com.pragma.bootcamp2024.configuration.exceptionhandler;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.CapacityAlreadyExistsException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.CapacityNotFoundException;
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

}
