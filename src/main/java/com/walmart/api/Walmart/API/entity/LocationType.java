package com.walmart.api.Walmart.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="locationtype")
@Getter
@Setter
public class LocationType {
    @Id
    private int locationTypeId;

    private String type;

    @OneToMany(mappedBy = "locationType")
    @JsonIgnore
    private List<Location> location;
}
