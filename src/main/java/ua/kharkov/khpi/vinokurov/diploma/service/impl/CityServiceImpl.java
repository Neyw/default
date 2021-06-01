package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.CityMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CityDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.CityRepository;
import ua.kharkov.khpi.vinokurov.diploma.repository.CountryRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.CityService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public CityDto getCityById(long id) {
        return cityRepository.findById(id)
                .map(cityMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDto> getAllCitiesByCountry(long countryId) {
        return countryRepository.findById(countryId)
                .map(cityRepository::findByCountry)
                .orElseGet(ArrayList::new)
                .stream()
                .map(cityMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto addCity(CityDto cityDto) {
        return cityMapper.entityToDto(cityRepository.save(cityMapper.dtoToEntity(cityDto)));
    }

    @Override
    public void deleteCity(long id) {
        cityRepository.deleteById(id);
    }
}
