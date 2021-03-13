package com.milunradonjic.basic_api_v3.mappers;

import com.milunradonjic.basic_api_v3.dtos.CountryDTO;
import com.milunradonjic.basic_api_v3.models.Country;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CityMapper.class })
@Component
public interface CountryMapper {

    String TO_ENTITY = "toEntity";
    String TO_DTO = "toDTO";

    @Named(TO_ENTITY)
    Country toEntity(CountryDTO countryDTO);

    @IterableMapping(qualifiedByName = TO_ENTITY)
    List<Country> toEntity(List<CountryDTO> countryDTOs);

    @Named(TO_DTO)
    CountryDTO toDTO(Country country);

    @IterableMapping(qualifiedByName = TO_DTO)
    List<CountryDTO> toDTO(List<Country> country);

}
