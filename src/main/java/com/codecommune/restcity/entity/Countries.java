package com.codecommune.restcity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Countries {

    private String iso2;

    private String iso3;

    private String country;

    private List<City> cities;
}
