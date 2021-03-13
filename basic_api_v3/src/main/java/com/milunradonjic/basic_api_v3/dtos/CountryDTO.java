package com.milunradonjic.basic_api_v3.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CountryDTO {

    private Long id;
    private String name;
    private Long population;
    private List<CityDTO> cities = new ArrayList<>();

}
