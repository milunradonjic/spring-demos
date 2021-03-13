package com.milunradonjic.basic_api_v2.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 30, message = "First name length has to be between 3 and 30 characters")
    private String firstName;

    @Size(min = 3, max = 30, message = "First name length has to be between 3 and 30 characters")
    private String lastName;

    @Email(message = "Not a valid email")
    @Column(name = "email", updatable = false, unique = true)
    private String email;

    @PositiveOrZero(message = "Age has to be a positive number or zero")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}

