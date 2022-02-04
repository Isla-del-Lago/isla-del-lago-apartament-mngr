package com.isladellago.apartmentmanager.service;

import com.isladellago.apartmentmanager.TestUtils;
import com.isladellago.apartmentmanager.domain.model.Apartment;
import com.isladellago.apartmentmanager.domain.model.ApartmentRepository;
import com.isladellago.apartmentmanager.exception.ApartmentNotFoundException;
import com.isladellago.apartmentmanager.service.impl.ApartmentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class ApartmentServiceImplTest {

    @Mock
    private ApartmentRepository apartmentRepository;

    @InjectMocks
    private ApartmentServiceImpl apartmentService;

    @Before
    public final void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public final void testGetApartmentById() {
        final Apartment mockApartment = TestUtils.getApartmentWithId1();
        Mockito.when(apartmentRepository.findById(TestUtils.APARTMENT_201_ID))
                .thenReturn(Optional.of(mockApartment));

        final Apartment apartment =
                apartmentService.getApartmentById(
                        TestUtils.UNIQUE_UUID, TestUtils.APARTMENT_201_ID
                );

        Assert.assertNotNull(apartment);
        Assert.assertEquals(mockApartment, apartment);
    }

    @Test(expected = ApartmentNotFoundException.class)
    public final void testGetApartmentByIdNotFound() {
        Mockito.when(apartmentRepository.findById(TestUtils.APARTMENT_201_ID))
                .thenReturn(Optional.empty());

        apartmentService
                .getApartmentById(TestUtils.UNIQUE_UUID, TestUtils.APARTMENT_201_ID);
    }

}
