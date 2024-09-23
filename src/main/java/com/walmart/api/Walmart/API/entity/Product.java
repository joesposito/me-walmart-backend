package com.walmart.api.Walmart.API.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private int productId;
    private String upc;
    private String fullName;
    private String shortenedName;
    private BigDecimal price;
    private String itemNumber;
    private int department;
    private int category;
    private String size;
    private String color;
    private String casePack;
    private String onHandCount;
    private String salesFloorCount;
    private String backroomCount;

    @OneToMany(mappedBy="product")
    private List<ProductLocation> productLocations;

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + productId +
                ", upc='" + upc + '\'' +
                ", full_name='" + fullName + '\'' +
                ", shortened_name='" + shortenedName + '\'' +
                ", price=" + price +
                ", item_number='" + itemNumber + '\'' +
                ", department=" + department +
                ", category=" + category +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", case_pack='" + casePack + '\'' +
                ", on_hand_count='" + onHandCount + '\'' +
                ", sales_floor_count='" + salesFloorCount + '\'' +
                ", backroom_count='" + backroomCount + '\'' +
                ", product_locations=" + productLocations +
                '}';
    }
}
