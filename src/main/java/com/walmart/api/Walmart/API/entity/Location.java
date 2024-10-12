package com.walmart.api.Walmart.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Location {
    @Id
    private int locationId;

    @Column(name = "location")
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_type_id")
    private LocationType locationType;

    @OneToMany(mappedBy="location")
    @JsonIgnore
    private List<ProductLocation> productLocations;
}
