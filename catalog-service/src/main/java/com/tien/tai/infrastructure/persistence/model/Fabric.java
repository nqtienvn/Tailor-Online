package com.tien.tai.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "fabrics")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    String code;
    String name;
    @Column(columnDefinition = "TEXT")
    String description;
    String color;
    Double pricePerMeter; //giá tiền trên một mét
    @Column(columnDefinition = "VARCHAR(100)")
    String imageUrl;
    Double stockQuantity; //số lượng mét vải
}
