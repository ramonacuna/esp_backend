package com.espe.infrastructure.dto;

import java.time.OffsetDateTime;

public class ErrorDtoException {
    private final Integer code;
    private final OffsetDateTime dateHour;
    private final String error;
    private final String message;

    public Integer getCode() {
        return code;
    }

    public OffsetDateTime getDateHour() {
        return dateHour;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDtoException(Integer code, OffsetDateTime dateHour, String error, String message) {
        this.code = code;
        this.dateHour = dateHour;
        this.error = error;
        this.message = message;
    }

}
