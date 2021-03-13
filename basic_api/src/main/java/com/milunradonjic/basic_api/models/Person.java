package com.milunradonjic.basic_api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String phoneNumber;

}
