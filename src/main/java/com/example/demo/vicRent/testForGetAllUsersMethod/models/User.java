package com.example.demo.vicRent.testForGetAllUsersMethod.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private Long id;


    private String firstName;
    private String lastName;
    private boolean expire;
}
