package com.tien.tai.infrastructure.persistence.model;

import com.tien.common.entity.Auditor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_items")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity extends Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String productName;
    Integer quantity;
    Double price;
    String fabricType;

    Boolean status = true;
    Boolean isDeleted = false;

    @Column(name = "orderid", nullable = false)
    int orderId;
}