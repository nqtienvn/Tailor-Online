package com.tien.tai.infrastructure.persistence.model;

import com.tien.common.entity.Auditor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends Auditor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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
