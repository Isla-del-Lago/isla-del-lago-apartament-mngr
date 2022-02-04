package com.isladellago.apartmentmanager.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    L102("L-102", "User not found"),
    L200("L-200", "Apartment not found");

    private final String errorMessage;
    private final String errorCode;
}
