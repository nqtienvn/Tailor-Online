package com.tien.tai.domain.command;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCmd {
    String username;
    String password;
    String fullName;
    String email;
    String phoneNumber;
    String address;
}
