package com.example.productcrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductModel {
    private long id;
    private String name;
    private long category;
    private long price;
    private String description;

    public ProductModel() {
    }
}
