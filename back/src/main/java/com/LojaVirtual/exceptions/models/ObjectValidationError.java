package com.LojaVirtual.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ObjectValidationError {
    private String message;
    private String field;
    private Object receivedValue;
}
