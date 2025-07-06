package kz.kop_flowers.model.exception;

import java.time.LocalDateTime;

public record ErrorResponse(String message, int status, LocalDateTime dateTime) {
}
