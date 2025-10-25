package com.espe.infrastructure.utility.mapper;

import java.time.OffsetDateTime;

public class HttpModelResponse<T> {
    private final Integer stateCode;
    private final OffsetDateTime hourDate;
    private final String message;
    private final T data;

    public Integer getStateCode() {
        return stateCode;
    }

    public OffsetDateTime getHourDate() {
        return hourDate;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public HttpModelResponse(Integer stateCode, String message, T data) {
        this.stateCode = stateCode;
        this.hourDate = OffsetDateTime.now();
        this.message = message;
        this.data = data;
    }
}
