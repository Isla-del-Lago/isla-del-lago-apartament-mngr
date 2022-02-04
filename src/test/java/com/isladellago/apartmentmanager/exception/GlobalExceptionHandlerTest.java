package com.isladellago.apartmentmanager.exception;

import com.isladellago.apartmentmanager.TestUtils;
import com.isladellago.apartmentmanager.domain.dto.ErrorResponseDTO;
import com.isladellago.apartmentmanager.domain.enums.ErrorCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    public final void testHandleUserNotFound() {
        final UserNotFoundException userNotFoundException =
                new UserNotFoundException(TestUtils.USER_EMAIL);

        final ResponseEntity<ErrorResponseDTO> response =
                globalExceptionHandler.handleUserNotFound(userNotFoundException);

        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assert.assertEquals(
                ErrorCodeEnum.L102.getErrorMessage(),
                response.getBody().getError());
        Assert.assertEquals(
                ErrorCodeEnum.L102.getErrorCode(),
                response.getBody().getErrorCode());
    }

    @Test
    public final void testHandleApartmentNotFound() {
        final ApartmentNotFoundException apartmentNotFoundException =
                new ApartmentNotFoundException(TestUtils.APARTMENT_201_ID);

        final ResponseEntity<ErrorResponseDTO> response =
                globalExceptionHandler.handleApartmentNotFound(apartmentNotFoundException);

        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assert.assertEquals(
                ErrorCodeEnum.L200.getErrorMessage(),
                response.getBody().getError());
        Assert.assertEquals(
                ErrorCodeEnum.L200.getErrorCode(),
                response.getBody().getErrorCode());
    }

}
