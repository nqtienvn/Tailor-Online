package com.tien.tai.domain.model;

import com.tien.tai.domain.command.CustomerCreateCmd;
import com.tien.tai.domain.command.CustomerUpdateCmd;
import com.tien.tai.infrastructor.persistence.model.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE) //chi goi dc setter ben trong class, chi de dam bao tinh encapsulation
@Getter
public class Customer {
    Integer id;
    String fullName;
    String phoneNumber;
    String email;
    Gender gender;
    LocalDate dateOfBirth;
    String note;
    Boolean isTemporary = false;
    Boolean status = true;

    public Customer(CustomerCreateCmd cmd) {
        this.fullName = cmd.getFullName();
        this.dateOfBirth = cmd.getDateOfBirth();
        this.email = cmd.getEmail();
        this.isTemporary = cmd.getIsTemporary();
        this.gender = cmd.getGender();
        this.status = true;
        this.note = cmd.getNote();
        this.phoneNumber = cmd.getPhoneNumber();
    }

    public void update(CustomerUpdateCmd customerUpdateCmd) {
        if (customerUpdateCmd.getPhoneNumber() != null) this.phoneNumber = customerUpdateCmd.getPhoneNumber();
        if (customerUpdateCmd.getNote() != null) this.note = customerUpdateCmd.getNote();
        if (customerUpdateCmd.getFullName() != null) this.fullName = customerUpdateCmd.getFullName();
        if (customerUpdateCmd.getIsTemporary() != null) this.isTemporary = customerUpdateCmd.getIsTemporary();
        if (customerUpdateCmd.getDateOfBirth() != null) this.dateOfBirth = customerUpdateCmd.getDateOfBirth();
        if (customerUpdateCmd.getGender() != null) this.gender = customerUpdateCmd.getGender();
    }

    public void inActive() {
        this.status = false;
    }

    public void active() {
        this.status = true;
    }
}
