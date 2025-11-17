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
        private Integer id;

        // Nếu DB đang dùng product_id (Integer) chứ không có product_name:
        @Column(name = "product_id", nullable = false)
        private Integer productId;

        @Column(name = "quantity", nullable = false)
        private Integer quantity;

        // DB là unit_price (không phải price)
        @Column(name = "unit_price", nullable = false)
        private Double price;

        // DB có subtotal -> nên map hoặc set default ở DB
        @Column(name = "subtotal")
        private Double subtotal;

        @Column(name = "fabric_type")
        private String fabricType;

        @Column(name = "status")
        private Boolean status = true;

        @Column(name = "is_deleted")
        private Boolean isDeleted = false;

        // Dùng wrapper để có thể null nếu cần; nếu bắt buộc có thì để nullable=false
        @Column(name = "order_id", nullable = false)
        private Integer orderId;
    }
