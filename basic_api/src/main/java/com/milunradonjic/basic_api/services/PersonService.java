package com.milunradonjic.basic_api.services;

import com.milunradonjic.basic_api.models.Person;
import com.milunradonjic.basic_api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {
        return personRepository.findById(id)
                .map(p -> {
                    p.setFirstName(person.getFirstName());
                    p.setLastName(person.getLastName());
                    p.setGender(person.getGender());
                    p.setPhoneNumber(person.getPhoneNumber());
                    return personRepository.save(p);
                })
                .orElseGet(() -> {
                    person.setId(id);
                    return personRepository.save(person);
                });
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public List<Person> findByFirstName(String firstName) {
        return personRepository.findAllByFirstName(firstName);
    }
}
