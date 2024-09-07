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
    private int product_id;
    private String upc;
    private String full_name;
    private String shortened_name;
    private BigDecimal price;
    private String item_number;
    private int department;
    private int category;
    private String size;
    private String color;
    private String case_pack;
    private String on_hand_count;
    private String sales_floor_count;
    private String backroom_count;

    @OneToMany(mappedBy="product")
    private List<ProductLocation> product_locations;

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", upc='" + upc + '\'' +
                ", full_name='" + full_name + '\'' +
                ", shortened_name='" + shortened_name + '\'' +
                ", price=" + price +
                ", item_number='" + item_number + '\'' +
                ", department=" + department +
                ", category=" + category +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", case_pack='" + case_pack + '\'' +
                ", on_hand_count='" + on_hand_count + '\'' +
                ", sales_floor_count='" + sales_floor_count + '\'' +
                ", backroom_count='" + backroom_count + '\'' +
                ", product_locations=" + product_locations +
                '}';
    }
}
