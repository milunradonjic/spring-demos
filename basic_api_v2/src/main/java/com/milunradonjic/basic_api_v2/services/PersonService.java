package com.milunradonjic.basic_api_v2.services;

import com.milunradonjic.basic_api_v2.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    Person findById(Long id);

    List<Person> findAll();

    Page<Person> findAll(Pageable pageable);

    Person create(Person person);

    Person update(Long id, Person person);

    void deleteById(Long id);

    List<Person> findAllByAgeBetween(Integer age1, Integer age2);
}
