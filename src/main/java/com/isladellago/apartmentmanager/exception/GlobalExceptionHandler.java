package com.isladellago.apartmentmanager.exception;

import com.isladellago.apartmentmanager.domain.dto.ErrorResponseDTO;
import com.isladellago.apartmentmanager.domain.enums.ErrorCodeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponseDTO> handleUserNotFound(
            UserNotFoundException ex) {
        log.error("User with email: {} not found", ex.getEmail());

        return buildErrorResponse(ErrorCodeEnum.L102, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApartmentNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleApartmentNotFound(
            ApartmentNotFoundException ex) {
        log.error("Apartment with id: {} not found",
                ex.getApartmentId());

        return buildErrorResponse(ErrorCodeEnum.L200, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponseDTO> buildErrorResponse(
            ErrorCodeEnum errorCodeEnum, HttpStatus httpStatus) {
        final ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .error(errorCodeEnum.getErrorMessage())
                .errorCode(errorCodeEnum.getErrorCode())
                .build();

        return ResponseEntity
                .status(httpStatus)
                .body(errorResponseDTO);
    }
}
