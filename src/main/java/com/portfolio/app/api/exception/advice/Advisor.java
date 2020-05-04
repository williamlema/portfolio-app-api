package com.portfolio.app.api.exception.advice;

import com.portfolio.app.api.exception.NotFoundPortfolioException;
import com.portfolio.app.api.exception.TimelineException;
import com.portfolio.app.api.model.dto.ErrorMessage;
import com.portfolio.app.api.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
* General exception handler
* 
* @author <a href="weleonm@gmail.com">William Leon</a>
* @version 1.0
* @since 1.0
*/

@ControllerAdvice
public class Advisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundPortfolioException.class)
    public ResponseEntity<Response<Object>> handleCityNotFoundException(NotFoundPortfolioException ex, WebRequest request) {
        return new ResponseEntity<>(new Response<Object>(new ErrorMessage(ex.getMessage())), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(TimelineException.class)
    public ResponseEntity<Response<Object>> handleTimelineException(TimelineException ex, WebRequest request) {
        return new ResponseEntity<>(new Response<Object>(new ErrorMessage(ex.getMessage())), HttpStatus.NOT_FOUND);
    }
}
