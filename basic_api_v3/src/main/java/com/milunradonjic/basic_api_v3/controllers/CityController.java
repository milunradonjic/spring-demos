package com.milunradonjic.basic_api_v3.controllers;


import com.milunradonjic.basic_api_v3.dtos.CityDTO;
import com.milunradonjic.basic_api_v3.mappers.CityMapper;
import com.milunradonjic.basic_api_v3.models.City;
import com.milunradonjic.basic_api_v3.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    private final CityService cityService;
    private CityMapper cityMapper;

    public CityController(CityService cityService, CityMapper cityMapper) {
        this.cityService = cityService;
        this.cityMapper = cityMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findById(@PathVariable Long id) {
        var city = cityService.findById(id);
        var result = cityMapper.toDTO(city);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        var cityList = cityService.findAll();
        var result = cityMapper.toDTO(cityList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityDTO> create(@Valid @RequestBody CityDTO cityDTO) {
        var city = cityMapper.toEntity(cityDTO);
        var result = cityMapper.toDTO(cityService.create(city));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        var city = cityMapper.toEntity(cityDTO);
        cityService.update(id, city);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
