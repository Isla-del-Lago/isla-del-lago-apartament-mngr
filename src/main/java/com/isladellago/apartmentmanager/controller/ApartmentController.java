package com.isladellago.apartmentmanager.controller;

import com.isladellago.apartmentmanager.domain.dto.ApartmentResponseDTO;
import com.isladellago.apartmentmanager.domain.model.Apartment;
import com.isladellago.apartmentmanager.service.ApartmentService;
import com.isladellago.apartmentmanager.util.CustomHttpHeaders;
import com.isladellago.apartmentmanager.util.PathUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(PathUtils.BASE_PATH)
@CrossOrigin("*")
@AllArgsConstructor
@Log4j2
public class ApartmentController {

    private ApartmentService apartmentService;

    @GetMapping("/apartmentId/{apartmentId}")
    public final ResponseEntity<ApartmentResponseDTO> getApartmentById(
            @RequestHeader(CustomHttpHeaders.UUID_HEADER) UUID uuid,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @PathVariable("apartmentId") String apartmentId) {
        log.info("[Get apartment by id controller] Apartment id: {}, uuid: {}, token: {}",
                apartmentId, uuid, authToken);

        final Apartment apartment =
                apartmentService.getApartmentById(uuid, apartmentId);

        final ApartmentResponseDTO response = ApartmentResponseDTO.builder()
                .apartmentId(apartment.getApartmentId())
                .users(apartment.getUsers())
                .build();

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}
