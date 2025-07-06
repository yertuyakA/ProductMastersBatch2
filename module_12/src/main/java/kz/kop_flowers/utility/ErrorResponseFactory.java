package kz.kop_flowers.utility;

import kz.kop_flowers.model.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.function.Function;

public class ErrorResponseFactory {

    public static Function<Exception, ErrorResponse> forStatus(HttpStatus status) {
        return ex -> new ErrorResponse(
                ex.getMessage(),
                status.value(),
                LocalDateTime.now()
        );
    }
}
