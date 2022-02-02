package com.isladellago.apartmentmanager.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {

    private String error;
    private String errorCode;
}
