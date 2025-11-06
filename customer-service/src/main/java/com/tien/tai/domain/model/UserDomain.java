package com.tien.tai.domain.model;

import com.tien.tai.domain.command.UserCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDomain {
    Integer id;
    String username;
    String password;
    String fullName;
    String email;
    String phoneNumber;
    String address;

    public static UserDomain create(UserCmd cmd) {
        return UserDomain.builder()
                .username(cmd.getUsername())
                .password(cmd.getPassword())
                .fullName(cmd.getFullName())
                .email(cmd.getEmail())
                .phoneNumber(cmd.getPhoneNumber())
                .address(cmd.getAddress())
                .build();
    }
    public UserDomain update(UserCmd cmd) {
        return null;
    }
    public void delete(Integer id) {}
}
