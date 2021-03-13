package com.milunradonjic.basic_api_v2.mappers;

import com.milunradonjic.basic_api_v2.dtos.PersonDTO;
import com.milunradonjic.basic_api_v2.models.Person;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface PersonMapper {

    Person toEntity(PersonDTO personDTO);
    List<Person> toEntity(List<PersonDTO> personDTOs);

    PersonDTO toDTO(Person person);
    List<PersonDTO> toDTO(List<Person> persons);

    default Page<Person> toEntity(Page<PersonDTO> personDTOs) {
        return personDTOs.map(this::toEntity);
    }

    default Page<PersonDTO> toDTO(Page<Person> persons) {
        return persons.map(this::toDTO);
    }
}
