package com.reto.intercop.model;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastname;

    private String email;

    private String dni;

    private String date_register;

    private String date_birth;

    public Customer(String name, String lastname, String email, String dni, String date_register, String date_birth) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.dni = dni;
        this.date_register = date_register;
        this.date_birth = date_birth;
    }
}
