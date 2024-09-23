package com.walmart.api.Walmart.API.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="productlocation")
@Getter
@Setter
public class ProductLocation {
    @Id
    private int productLocationId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
