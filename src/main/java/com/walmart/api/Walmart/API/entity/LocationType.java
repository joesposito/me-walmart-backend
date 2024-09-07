package com.walmart.api.Walmart.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="locationtype")
@Getter
@Setter
public class LocationType {
    @Id
    private int location_type_id;
    private String type;

    @OneToMany(mappedBy = "location_type")
    @JsonIgnore
    private List<Location> location;
}
