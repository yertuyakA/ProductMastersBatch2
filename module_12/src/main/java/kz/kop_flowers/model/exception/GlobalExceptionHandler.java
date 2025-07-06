package kz.kop_flowers.model.exception;

import kz.kop_flowers.utility.ErrorResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.function.Function;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Function<Exception, ErrorResponse> NOT_FOUND_MAPPER =
            ErrorResponseFactory.forStatus(HttpStatus.NOT_FOUND);

    @ExceptionHandler(FlowerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFlowerNotFound(FlowerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_MAPPER.apply(ex));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCategoryNotFound(CategoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_MAPPER.apply(ex));
    }
}
