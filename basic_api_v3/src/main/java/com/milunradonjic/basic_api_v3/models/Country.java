package com.milunradonjic.basic_api_v3.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = "cities")
@EqualsAndHashCode(exclude = "cities")
public class Country {pom

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long population;

    @OneToMany(mappedBy = "country",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<>();

}
