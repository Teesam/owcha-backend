package com.example.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class userDto {

    @GeneratedValue
    @Id
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String location;
    private String gender;
    private String username;
    private List<String> roles = new ArrayList<>();
    private String password;
    private String address;
    private String postcode;

}
