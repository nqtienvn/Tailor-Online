package com.tien.tai.application.dto.response;

import jakarta.persistence.FieldResult;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRespose {
    Integer id;
    String username;
    String fullName;
    String email;
    String phoneNumber;
    String address;

}
