package ua.kharkov.khpi.vinokurov.diploma.service;


import ua.kharkov.khpi.vinokurov.diploma.model.dto.CountryDto;

import java.util.List;

public interface CountryService {
    CountryDto getCountryById(long id);

    List<CountryDto> getAllCountries();

    CountryDto addCountry(CountryDto country);

    void deleteCountry(long id);
}
