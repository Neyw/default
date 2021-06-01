package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.StationDto;

import java.util.List;
import java.util.Optional;

public interface StationService {
    Optional<StationDto> getStation(long id);

    Optional<StationDto> updateName(long id, String newName);

    List<StationDto> getAllStations();

    List<StationDto> getStationsByCity(long cityId);

    StationDto createStation(StationDto stationDto);

    void deleteStation(long stationId);


}
