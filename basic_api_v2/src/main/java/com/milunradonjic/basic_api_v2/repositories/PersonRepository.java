package com.milunradonjic.basic_api_v2.repositories;

import com.milunradonjic.basic_api_v2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByAgeBetween(Integer age1, Integer age2);

}
