package com.milunradonjic.basic_api_v3.mappers;

import com.milunradonjic.basic_api_v3.dtos.CityDTO;
import com.milunradonjic.basic_api_v3.models.City;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CountryMapper.class })
@Component
public interface CityMapper {

    String TO_DTO = "toDTO";
    String TO_ENTITY = "toEntity";

    @Named(TO_ENTITY)
    @Mapping(target = "country.id", source = "countryId")
    City toEntity(CityDTO cityDTO);

    @IterableMapping(qualifiedByName = TO_ENTITY)
    List<City> toEntity(List<CityDTO> cities);

    @Named(TO_DTO)
    @Mapping(target = "countryId", source = "country.id")
    CityDTO toDTO(City city);

    @IterableMapping(qualifiedByName = TO_DTO)
    List<CityDTO> toDTO(List<City> cities);

}
