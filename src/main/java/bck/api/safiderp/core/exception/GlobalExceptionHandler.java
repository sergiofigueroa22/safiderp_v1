package bck.api.safiderp.core.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
       
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(GenericException ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("errorCode", "NOT_FOUND");
        response.put("errorMessage", ex.getMessage());
        response.put("timestamp", System.currentTimeMillis());
        HttpStatus status = (ex instanceof GenericException) 
                            ? HttpStatus.NOT_FOUND 
                            : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("errorCode", "INTERNAL_ERROR");
        response.put("errorMessage", "An unexpected error occurred");
        response.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}