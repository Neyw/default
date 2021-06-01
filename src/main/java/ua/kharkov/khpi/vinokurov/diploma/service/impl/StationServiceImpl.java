package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.StationMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.StationDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.CityRepository;
import ua.kharkov.khpi.vinokurov.diploma.repository.StationRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.StationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StationMapper stationMapper;

    @Override
    public Optional<StationDto> getStation(long id) {
        return stationRepository.findById(id)
                .map(stationMapper::entityToDto);
    }

    @Override
    public Optional<StationDto> updateName(long id, String newName) {
        final Optional<StationDto> station = getStation(id);
        station.ifPresent(stationDto -> stationDto.setName(newName));
        return station.map(stationMapper::dtoToEntity)
                .map(stationRepository::save)
                .map(stationMapper::entityToDto);
    }

    @Override
    public List<StationDto> getAllStations() {
        return stationRepository.findAll()
                .stream()
                .map(stationMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StationDto> getStationsByCity(long cityId) {
        return cityRepository.findById(cityId)
                .map(stationRepository::findByCity)
                .orElseGet(ArrayList::new)
                .stream()
                .map(stationMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StationDto createStation(StationDto stationDto) {
        return stationMapper.entityToDto(stationRepository.save(stationMapper.dtoToEntity(stationDto)));
    }

    @Override
    public void deleteStation(long stationId) {
        stationRepository.deleteById(stationId);
    }
}
