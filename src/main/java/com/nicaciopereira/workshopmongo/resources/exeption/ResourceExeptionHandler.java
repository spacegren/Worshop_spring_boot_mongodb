package com.nicaciopereira.workshopmongo.resources.exeption;

import com.nicaciopereira.workshopmongo.services.exeption.ObjectNotFoundExeption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExeptionHandler {

    //QUNADO OCORRER A EXEÇAO ELE ENTENDE QUE TEM QUE FAZER ISSO
    @ExceptionHandler(value =ObjectNotFoundExeption.class )
    public ResponseEntity<StandardError> objNotFound(ObjectNotFoundExeption e , HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis() ,status.value(), "NAO ENCONTRADO" ,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }
}
