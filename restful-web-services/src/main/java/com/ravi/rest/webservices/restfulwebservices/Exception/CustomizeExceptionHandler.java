package com.ravi.rest.webservices.restfulwebservices.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice:To Include all the controllers
@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr){
        ExceptionResponse er=new ExceptionResponse(new Date(),ex.getMessage(),
                wr.getDescription(false));
        return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest request){
        ExceptionResponse er=new ExceptionResponse(new Date(),ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(er, HttpStatus.NOT_FOUND);
    }

    //Below method was implemented for validation of user, while post request, i.e. creating user
    //By Using @Valid, we are validating user
    //In User class by @Size we sre validating name and by @Past we are using to validate Birthdate
    //Below method is overridden to provide proper message to end user, deviating from default by using bindresult

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        //Default implementation
        //return this.handleExceptionInternal(ex, (Object)null, headers, status, request);

        ExceptionResponse er=new ExceptionResponse(new Date(),ex.getMessage(),
                ex.getBindingResult().toString());

        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }

}
