package com.tien.tai.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Product extends Auditor{
    @Id
    @GeneratedValue
    Integer id;
    Integer categoryId;
    Integer fabricId;
    String name;
    @Column(columnDefinition = "TEXT")
    String description;
    Double basePrice; //công may cơ bản
    Boolean status = true;
    Boolean isDeleted = false;
}
