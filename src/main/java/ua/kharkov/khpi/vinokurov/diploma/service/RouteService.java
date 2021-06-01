package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.RouteDto;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface RouteService {

    List<RouteDto> findByStations(long beginStationId, long endStationId);

    List<RouteDto> findByStation(long stationId);

    Optional<RouteDto> getById(long id);

    List<RouteDto> getAllRoutes();

    RouteDto create(RouteDto routeDto);

    Optional<RouteDto> updateBeginTime(long routeId, LocalTime newBeginTime);

    Optional<RouteDto> updateEndTime(long routeId, LocalTime newEndTime);

    Optional<RouteDto> updateBeginStation(long routeId, long stationId);

    Optional<RouteDto> updateEndStation(long routeId, long stationId);

    void delete(long id);
}
