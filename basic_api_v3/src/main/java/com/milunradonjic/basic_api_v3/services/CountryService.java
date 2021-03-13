package com.milunradonjic.basic_api_v3.services;

import com.milunradonjic.basic_api_v3.models.Country;
import com.milunradonjic.basic_api_v3.repositories.CountryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country create(Country country) {
        return countryRepository.save(country);
    }
    
    public Country update(Long id, Country country) {
        return countryRepository.findById(id)
                .map(countryFromDB -> {
                    BeanUtils.copyProperties(country, countryFromDB);
                    countryFromDB.setId(id);
                    return countryRepository.save(countryFromDB);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

}
