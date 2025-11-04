package com.tien.tai.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue
    Integer id;
    Integer categoryId;
    Integer fabricId;
    String name;
    @Column(columnDefinition = "TEXT")
    String description;
    Double basePrice; //công may cơ bản
}
