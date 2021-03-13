package com.milunradonjic.basic_api_v3.repositories;

import com.milunradonjic.basic_api_v3.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {


}
