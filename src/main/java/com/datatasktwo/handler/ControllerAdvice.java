package com.datatasktwo.handler;

import com.datatasktwo.exception.DepartmentNotFoundException;
import com.datatasktwo.exception.EmployeeNotFoundException;
import com.datatasktwo.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException(Exception ex){
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDepartmentNotFoundException(Exception ex){
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
