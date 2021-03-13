package com.milunradonjic.basic_api_v3.services;

import com.milunradonjic.basic_api_v3.models.City;
import com.milunradonjic.basic_api_v3.repositories.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }
    
    public City create(City city) {
        return cityRepository.save(city);
    }

    public City update(Long id, City city) {
        return cityRepository.findById(id)
                .map(cityFromDB -> {
                    BeanUtils.copyProperties(city, cityFromDB);
                    cityFromDB.setId(id);
                    return cityRepository.save(cityFromDB);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    public void deleteCity(City city) {
        cityRepository.delete(city);
    }

}
