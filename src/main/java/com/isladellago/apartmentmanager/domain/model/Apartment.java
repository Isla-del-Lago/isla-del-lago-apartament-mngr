package com.isladellago.apartmentmanager.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartment")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public final class Apartment {

    @Id
    @Column(name = "apartment_id")
    private String apartmentId;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "apartment")
    private List<User> users;
}
