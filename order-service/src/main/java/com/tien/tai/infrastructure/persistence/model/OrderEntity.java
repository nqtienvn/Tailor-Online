package com.tien.tai.infrastructure.persistence.model;

import com.tien.common.constant.OrderStatus;
import com.tien.common.entity.Auditor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String customerName;
    String customerPhone;
    @Column(columnDefinition = "VARCHAR(500)")
    String customerAddress;
    Double totalAmount;
    Double depositAmount;//tiền cọc
    @Enumerated(EnumType.STRING)
    OrderStatus status;
}