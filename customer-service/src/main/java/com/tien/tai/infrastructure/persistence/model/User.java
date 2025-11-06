package com.tien.tai.infrastructure.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @NotNull
    private String password;

    @Email(message = "sai dinh dang")
    @NotNull
    private String email;

    private String fullName;

    private String phoneNumber;

    private String address;
}
