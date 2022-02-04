package com.isladellago.apartmentmanager.service.impl;

import com.isladellago.apartmentmanager.domain.model.Apartment;
import com.isladellago.apartmentmanager.domain.model.ApartmentRepository;
import com.isladellago.apartmentmanager.exception.ApartmentNotFoundException;
import com.isladellago.apartmentmanager.service.ApartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@AllArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentRepository apartmentRepository;

    @Override
    public Apartment getApartmentById(UUID uuid, String apartmentId) {
        log.info("[Get apartment by id service] Apartment id: {}, uuid: {}",
                apartmentId, uuid);

        return apartmentRepository
                .findById(apartmentId)
                .orElseThrow(() -> new ApartmentNotFoundException(apartmentId));
    }
}
