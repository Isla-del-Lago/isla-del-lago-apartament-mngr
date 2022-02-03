package com.isladellago.apartmentmanager.service;

import com.isladellago.apartmentmanager.domain.model.Apartment;

import java.util.UUID;

public interface ApartmentService {

    Apartment getApartmentById(UUID uuid, String apartmentId);

}
