package com.milunradonjic.basic_api_v2.dtos;

import com.milunradonjic.basic_api_v2.models.Gender;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {

    private Long id;

    @NotBlank(message = "First name can not be blank")
    @Size(min = 3, max = 30, message = "First name length has to be between 3 and 30 characters")
    private String firstName;

    @NotBlank(message = "Last name can not be blank")
    @Size(min = 3, max = 30, message = "First name length has to be between 3 and 30 characters")
    private String lastName;

    @NotBlank(message = "Email can not be blank")
    @Email(message = "Not a valid email")
    private String email;

    @PositiveOrZero(message = "Age has to be a positive number or zero")
    private Integer age;

    private Gender gender;

}
