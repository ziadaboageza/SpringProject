package com.fawry.springproject.exception;

import lombok.*;

import java.util.Map;

@Getter
@Setter
public class ExceptionValidationMessage extends StatusMessage {

    Map<String, String> errors;

    public ExceptionValidationMessage(ExceptionMessage exception, Map<String, String> errors) {
        super(exception.getCode(), exception.getStatus(), exception.getTimestamp());
        this.errors = errors;
    }

}
