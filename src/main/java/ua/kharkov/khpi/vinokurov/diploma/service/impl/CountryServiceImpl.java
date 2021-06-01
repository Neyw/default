package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.CountryMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CountryDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.CountryRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public CountryDto getCountryById(long id) {
        return countryRepository.findById(id)
                .map(countryMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto addCountry(CountryDto country) {
        return countryMapper.entityToDto(countryRepository.save(countryMapper.dtoToEntity(country)));
    }

    @Override
    public void deleteCountry(long id) {
        countryRepository.deleteById(id);
    }
}
