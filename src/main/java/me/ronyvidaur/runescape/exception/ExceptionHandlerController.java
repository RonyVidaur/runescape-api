package me.ronyvidaur.runescape.exception;


import me.ronyvidaur.runescape.util.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class})
//    protected ResponseEntity<Object> handleConflict(RuntimeException ex, HttpServletRequest request) {
//        String bodyOfResponse = "ILLEGAL STATEMENT " +" " + request.getPathInfo()  + " "+ ex;
////        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);


    @ExceptionHandler({DataIntegrityViolationException.class, SQLException.class})
    public ResponseEntity handleSQLException(HttpServletRequest request, Exception ex){
        logger.info("SQLException Occured:: URL="+ request.getRequestURL());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseBuilder.build("error", request.getMethod(),request.getRequestURI()));
    }



}
