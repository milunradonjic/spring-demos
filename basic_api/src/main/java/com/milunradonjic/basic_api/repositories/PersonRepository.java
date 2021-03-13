package com.milunradonjic.basic_api.repositories;

import com.milunradonjic.basic_api.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByFirstName(String firstName);

}
