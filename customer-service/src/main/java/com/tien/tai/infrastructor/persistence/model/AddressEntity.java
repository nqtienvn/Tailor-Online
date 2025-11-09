package com.tien.tai.infrastructor.persistence.model;

import com.tien.common.entity.Auditor;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressEntity extends Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer customerId;
    @Description("địa chỉ chi tiết: số nhà 55/34 đại tự")
    String addressLine;
    @Description("Tên thành phố, tỉnh: Bắc Ninh")
    String city;
    @Description("Tên Quận Huyện: Yên Dũng")
    String district;
    @Description("Tên phường xã: đồng phúc")
    String ward;
    @Enumerated(EnumType.STRING)
    @Description("Nhận hàng tại địa chỉ nhà riêng hay tại nơi làm việc,...")
    AddressType addressType;
    @Description("Lưu địa chỉ thành mặc định hay không")
    Boolean isDefault;
}
