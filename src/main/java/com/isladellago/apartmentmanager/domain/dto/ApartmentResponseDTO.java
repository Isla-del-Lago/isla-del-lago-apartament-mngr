package com.isladellago.apartmentmanager.domain.dto;

import com.isladellago.apartmentmanager.domain.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This class maps the apartment response dto.
 */
@Getter
@Setter
@ToString
@Builder
public final class ApartmentResponseDTO {

    private String apartmentId;
    private List<User> users;
}
