package org.api.fakestoreapi.controller;

import org.api.fakestoreapi.exception.IdNotValiedException;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


/**
 * @author yogeshjoga
 *
 * The ControllerAdvisor class is a global exception handler for handling specific application exceptions.
 * It provides centralized mechanisms to handle errors and respond with appropriate HTTP status codes and messages.
 */
@RestControllerAdvice
public class ControllerAdvisor {



    private MultiValueMap<String, String> headers;

    /**
     * Handles exceptions of type ThirdPartyAPIException and returns an appropriate HTTP response.
     *
     * @param e The exception instance of type ThirdPartyAPIException containing details about the error.
     * @return A ResponseEntity with HTTP status 500 (Internal Server Error) and the exception message as the response body.
     */
    @ExceptionHandler(ThirdPartyAPIException.class)
    public ResponseEntity<String> thirdPartyAPIExceptionHandler(Exception e){
        return ResponseEntity.status(500).body(e.getMessage());
    }

    /**
     * Handles exceptions of type IdNotValiedException and returns an appropriate HTTP response.
     *
     * @param e The exception instance of type IdNotValiedException containing details about the error.
     * @return A ResponseEntity with HTTP status 400 (Bad Request) and the exception message as the response body.
     */
    @ExceptionHandler(IdNotValiedException.class)
    public ResponseEntity<String> idNotValiedExceptionHandler(Exception e){
        headers = new LinkedMultiValueMap<>();
        headers.add("Date", LocalDateTime.now().toString());
        headers.add("Id_Not Valid", "Id Not Valid change ID");
        return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.BAD_REQUEST);
        // return ResponseEntity.status(400).body(e.getMessage());
    }

}
