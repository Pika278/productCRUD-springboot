package com.example.productcrud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {
    @Id
    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "categoryID")
    private long categoryID;
    @Column(name = "price")
    private long price;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryEntity categoryEntity;

}
