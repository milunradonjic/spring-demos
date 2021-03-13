package com.milunradonjic.basic_api_v3.controllers;


import com.milunradonjic.basic_api_v3.dtos.CountryDTO;
import com.milunradonjic.basic_api_v3.mappers.CountryMapper;
import com.milunradonjic.basic_api_v3.models.Country;
import com.milunradonjic.basic_api_v3.services.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService countryService;
    private CountryMapper countryMapper;

    public CountryController(CountryService countryService, CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> findById(@PathVariable Long id) {
        var country = countryService.findById(id);
        var result = countryMapper.toDTO(country);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> findAll() {
        var countryList = countryService.findAll();
        var result = countryMapper.toDTO(countryList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> create(@Valid @RequestBody CountryDTO countryDTO) {
        var country = countryMapper.toEntity(countryDTO);
        var result = countryMapper.toDTO(countryService.create(country));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        var country = countryMapper.toEntity(countryDTO);
        countryService.update(id, country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
