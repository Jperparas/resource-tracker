package io.github.jperparas.resourcetrackerpwa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException ex) {
        String message = ex.getMessage() == null || ex.getMessage().isEmpty()
                ? "Resource not found"
                : ex.getMessage();
        Map<String, String> error = Map.of("message", message);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequestException(BadRequestException ex) {
        String message = ex.getMessage() == null || ex.getMessage().isEmpty()
                ? "Bad request"
                : ex.getMessage();
        Map<String, String> error = Map.of("message", message);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
