package com.codecommune.restcity.controller;

import com.codecommune.restcity.entity.Countries;
import com.codecommune.restcity.entity.DataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {

    List<Countries> countries=new ArrayList<>();
    @GetMapping("/cities")
    public List<Countries> getCountries(){
        String  uri ="https://countriesnow.space/api/v0.1/countries";
        RestTemplate restTemplate = new RestTemplate();
       Object[] objects= new Object[]{restTemplate.getForObject(uri, Object.class)};
        ObjectMapper objectMapper = new ObjectMapper();
        countries= Arrays.stream(objects).map(o->objectMapper.convertValue(o,DataResponse.class))
                .map(DataResponse::getData)
                .collect(Collectors.toList()).get(0);
       return countries;
    }

    @GetMapping("/city")
    public List<Countries> getCity(){
    return countries.stream().filter(e->e.getCountry().equals("Zimbabwe")).collect(Collectors.toList());
    }
}
