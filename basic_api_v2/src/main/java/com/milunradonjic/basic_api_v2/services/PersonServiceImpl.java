package com.milunradonjic.basic_api_v2.services;

import com.milunradonjic.basic_api_v2.models.Person;
import com.milunradonjic.basic_api_v2.repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        return personRepository.findById(id)
                .map(personFromDB -> {
                    BeanUtils.copyProperties(person, personFromDB);
                    personFromDB.setId(id);
                    return personRepository.save(personFromDB);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> findAllByAgeBetween(Integer age1, Integer age2) {
        return personRepository.findAllByAgeBetween(age1, age2);
    }
}
