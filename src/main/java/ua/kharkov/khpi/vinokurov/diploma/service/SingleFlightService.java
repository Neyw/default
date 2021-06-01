package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SingleFlightService {
    List<SingleFlightDto> findByRouteId(long routeId);

    List<SingleFlightDto> findByBeginDateAndStations(Date beginDate, long beginStationId, long endStationId);

    List<SingleFlightDto> getAllSingleFlight();

    Optional<SingleFlightDto> getById(long id);

    SingleFlightDto create(SingleFlightDto singleflightDto);

    Optional<SingleFlightDto> updatePlane(long singleflightId, long planeId);

    Optional<SingleFlightDto> updateDate(long singleflightId, LocalDate date);

    void delete(long id);
}
