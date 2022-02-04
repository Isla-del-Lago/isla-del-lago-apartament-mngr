package com.isladellago.apartmentmanager;

import com.isladellago.apartmentmanager.domain.model.Apartment;
import com.isladellago.apartmentmanager.domain.model.User;

import java.util.List;
import java.util.UUID;

public final class TestUtils {

    public static final UUID UNIQUE_UUID = UUID.randomUUID();
    public static final String TOKEN = UUID.randomUUID().toString();
    public static final String APARTMENT_201_ID = "Apartamento 201";

    public static final String USER_EMAIL = "user-test@isladellago.com";

    public static Apartment getApartmentWithId1() {
        return Apartment.builder()
                .apartmentId(APARTMENT_201_ID)
                .users(List.of())
                .build();
    }

    public static final User getUserByEmail1() {
        return User.builder()
                .email(USER_EMAIL)
                .build();
    }

    private TestUtils() {
        throw new AssertionError();
    }
}
