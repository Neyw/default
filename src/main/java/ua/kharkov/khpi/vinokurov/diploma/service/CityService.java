package ua.kharkov.khpi.vinokurov.diploma.service;


import ua.kharkov.khpi.vinokurov.diploma.model.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto getCityById(long id);

    List<CityDto> getAllCities();

    List<CityDto> getAllCitiesByCountry(long countryId);

    CityDto addCity(CityDto cityDto);

    void deleteCity(long id);
}
