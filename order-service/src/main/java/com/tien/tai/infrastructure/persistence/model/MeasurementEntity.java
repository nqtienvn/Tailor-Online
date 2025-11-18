package com.tien.tai.infrastructure.persistence.model;

import com.tien.common.entity.Auditor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "measurements")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementEntity extends Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // Các cột số đo (giữ nguyên tên cột trong DB)
    @Column(name = "chest")
    Double chest;

    @Column(name = "waist")
    Double waist;

    @Column(name = "hips")
    Double hips;

    @Column(name = "shoulder")
    Double shoulder;

    @Column(name = "sleeve_length")
    Double sleeveLength;

    @Column(name = "trouser_length")
    Double trouserLength;

    // Cờ trạng thái
    @Column(name = "status")
    Boolean status = true;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    // Khóa ngoại về orders(id) – bạn đang map thủ công nên chỉ cần int/Integer + @Column
    @Column(name = "order_id", nullable = false)
    Integer orderId;
}
