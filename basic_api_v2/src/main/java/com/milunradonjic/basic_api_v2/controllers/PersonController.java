package com.milunradonjic.basic_api_v2.controllers;


import com.milunradonjic.basic_api_v2.dtos.PersonDTO;
import com.milunradonjic.basic_api_v2.mappers.PersonMapper;
import com.milunradonjic.basic_api_v2.models.Person;
import com.milunradonjic.basic_api_v2.services.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;
    private PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        Person person = personService.findById(id);
        PersonDTO result = personMapper.toDTO(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<Person> personList = personService.findAll();
        List<PersonDTO> result = personMapper.toDTO(personList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PersonDTO>> findAll(Pageable pageable) {
        Page<Person> personList = personService.findAll(pageable);
        Page<PersonDTO> result = personMapper.toDTO(personList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        PersonDTO result = personMapper.toDTO(personService.create(person));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        personService.update(id, person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/between-ages")
    public ResponseEntity<List<PersonDTO>> findAllByAgeBetween(@RequestParam(name = "age1") Integer age1,
                                                               @RequestParam(name = "age2") Integer age2) {
        List<PersonDTO> result = personMapper.toDTO(personService.findAllByAgeBetween(age1, age2));
        return ResponseEntity.ok(result);
    }
}
