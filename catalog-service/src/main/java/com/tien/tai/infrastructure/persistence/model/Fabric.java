package com.tien.tai.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "fabrics")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Fabric extends Auditor{
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
    Boolean status = true;
    Boolean isDeleted = false;
}
