package com.tien.tai.infrastructor.persistence.model;

import com.tien.common.entity.Auditor;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerEntity extends Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fullName;
    String phoneNumber;
    String email;
    @Enumerated(EnumType.STRING)
    Gender gender;
    LocalDate dateOfBirth;
    String note;
    @Description("khách hàng may đồ trực tiếp, khi tạo để là true, sau khi hoàn tất thì có thể dọn dẹp")
    Boolean isTemporary = false;
    Boolean status = true;
}
