package com.isladellago.apartmentmanager.controller;

import com.isladellago.apartmentmanager.TestUtils;
import com.isladellago.apartmentmanager.domain.dto.ApartmentResponseDTO;
import com.isladellago.apartmentmanager.service.ApartmentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApartmentControllerTest {

    @Mock
    private ApartmentService apartmentService;

    @InjectMocks
    private ApartmentController apartmentController;

    @Before
    public final void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public final void getApartmentByIdTest() {
        Mockito.when(apartmentService.getApartmentById(TestUtils.UNIQUE_UUID, TestUtils.APARTMENT_201_ID))
                .thenReturn(TestUtils.getApartmentWithId1());

        final ResponseEntity<ApartmentResponseDTO> response =
                apartmentController.getApartmentById(
                        TestUtils.UNIQUE_UUID, TestUtils.TOKEN, TestUtils.APARTMENT_201_ID
                );

        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(
                TestUtils.getApartmentWithId1().getApartmentId(),
                response.getBody().getApartmentId()
        );
        Assert.assertEquals(0, response.getBody().getUsers().size());
    }
}
