package com.espe.infrastructure.exception;

import com.espe.infrastructure.dto.ErrorDtoException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerException {

    private static final Logger log = LoggerFactory.getLogger(ControllerException.class);

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorDtoException> noAvailableSize(MaxUploadSizeExceededException ex) {
        return BuildResponse(HttpStatus.PAYLOAD_TOO_LARGE, "File's size no available", ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDtoException> noFound(NoSuchElementException ex) {
        return BuildResponse(HttpStatus.NOT_FOUND, "No found source", ex.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorDtoException> invalidArgument(RuntimeException ex) {
        return BuildResponse(HttpStatus.BAD_REQUEST, "Invalid argument", ex.getMessage());
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorDtoException> unknownProperty(UnrecognizedPropertyException ex) {
        String campo = ex.getPropertyName();
        String msg = "The field '" + campo + "' isn't recognize. Verify the JSON's structure";
        return BuildResponse(HttpStatus.BAD_REQUEST, "unknown property", msg);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDtoException> businessConflict(BusinessException ex) {
        return BuildResponse(HttpStatus.CONFLICT, "Business rule error", ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDtoException> validationError(ValidationException ex) {
        return BuildResponse(HttpStatus.BAD_REQUEST, "Validation error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDtoException> errorGeneral(Exception ex) {
        log.error("Error no controller", ex);

        String details = (ex.getMessage() != null && !ex.getMessage().isBlank())
                ? ex.getMessage()
                : "Error unexpected. Contact with admin";

        return BuildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server error",
                details
        );
    }

    private ResponseEntity<ErrorDtoException> BuildResponse(HttpStatus estate, String error, String detail) {
        ErrorDtoException response = new ErrorDtoException(
                estate.value(),
                OffsetDateTime.now(),
                error,
                detail
        );
        return ResponseEntity.status(estate).body(response);
    }
}