package com.walmart.api.Walmart.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    @Id
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
