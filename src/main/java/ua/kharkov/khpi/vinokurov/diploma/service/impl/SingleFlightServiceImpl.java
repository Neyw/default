package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.RouteMapper;
import ua.kharkov.khpi.vinokurov.diploma.mapper.SingleFlightMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.SeatType;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.RouteDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.SingleFlightRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.PlaneService;
import ua.kharkov.khpi.vinokurov.diploma.service.RouteService;
import ua.kharkov.khpi.vinokurov.diploma.service.SingleFlightService;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SingleFlightServiceImpl implements SingleFlightService {
    @Autowired
    private SingleFlightRepository singleFlightRepository;
    @Autowired
    private SingleFlightMapper singleFlightMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private RouteService routeService;
    @Autowired
    private PlaneService planeService;

    @Override
    public List<SingleFlightDto> findByRouteId(long routeId) {
        return singleFlightRepository.findAllByRoute(routeMapper.dtoToEntity(RouteDto.builder().id(routeId).build()))
                .stream()
                .map(singleFlightMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SingleFlightDto> findByBeginDateAndStations(Date beginDate, long beginStationId, long endStationId) {
        final List<RouteDto> routes = routeService.findByStations(beginStationId, endStationId);
        return singleFlightRepository.findByDateAndRouteIdIn(beginDate, routes.stream()
                .map(RouteDto::getId)
                .collect(Collectors.toList()))
                .stream()
                .map(singleFlightMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SingleFlightDto> getAllSingleFlight() {
        return singleFlightRepository.findAll()
                .stream()
                .map(singleFlightMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SingleFlightDto> getById(long id) {
        return singleFlightRepository.findById(id)
                .map(singleFlightMapper::entityToDto);
    }

    @Override
    public SingleFlightDto create(SingleFlightDto singleflightDto) {
        routeService.getById(singleflightDto.getRoute().getId())
                .ifPresent(singleflightDto::setRoute);
        IntStream.range(0, 10)
                .forEach(k -> singleflightDto.getSeat().add(SeatDto.builder()
                        .price(BigDecimal.TEN)
                        .number(k + 1)
                        .type(SeatType.SECOND_CLASS)
                        .build()));

        return singleFlightMapper.entityToDto(singleFlightRepository.save(singleFlightMapper.dtoToEntity(singleflightDto)));
    }

    @Override
    public Optional<SingleFlightDto> updatePlane(long singleFlightId, long planeId) {
        final Optional<SingleFlightDto> singleFlightDto = getById(singleFlightId);
        singleFlightDto.ifPresent(singleFlight -> planeService.getById(planeId)
                .ifPresent(singleFlight::setPlane));
        return singleFlightDto.map(singleFlightMapper::dtoToEntity)
                .map(singleFlightRepository::save)
                .map(singleFlightMapper::entityToDto);
    }

    @Override
    public Optional<SingleFlightDto> updateDate(long singleFlightId, LocalDate date) {
        final Optional<SingleFlightDto> singleFlightDto = getById(singleFlightId);
        singleFlightDto.ifPresent(singleFlight -> singleFlight.setDate(date));
        return singleFlightDto.map(singleFlightMapper::dtoToEntity)
                .map(singleFlightRepository::save)
                .map(singleFlightMapper::entityToDto);
    }

    @Override
    public void delete(long id) {
        singleFlightRepository.deleteById(id);
    }
}
