package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.RouteMapper;
import ua.kharkov.khpi.vinokurov.diploma.mapper.StationMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.RouteDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.StationDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.RouteEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.StationEntity;
import ua.kharkov.khpi.vinokurov.diploma.repository.RouteRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.RouteService;
import ua.kharkov.khpi.vinokurov.diploma.service.StationService;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private StationMapper stationMapper;

    @Override
    public List<RouteDto> findByStations(long beginStationId, long endStationId) {
        StationEntity beginStation = stationMapper.dtoToEntity(StationDto.builder().id(beginStationId).build());
        StationEntity endStation = stationMapper.dtoToEntity(StationDto.builder().id(endStationId).build());
        return routeRepository.findAllByStartStationAndEndStation(beginStation, endStation)
                .stream()
                .map(routeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RouteDto> findByStation(long stationId) {
        StationEntity stationEntity = stationMapper.dtoToEntity(StationDto.builder().id(stationId).build());
        final List<RouteEntity> routes = routeRepository.findAllByStartStation(stationEntity);
        routes.addAll(routeRepository.findAllByEndStation(stationEntity));
        return routes.stream()
                .map(routeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RouteDto> getById(long id) {
        return routeRepository.findById(id)
                .map(routeMapper::entityToDto);
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteDto create(RouteDto routeDto) {
        return routeMapper.entityToDto(routeRepository.save(routeMapper.dtoToEntity(routeDto)));
    }

    @Override
    public Optional<RouteDto> updateBeginTime(long routeId, LocalTime newBeginTime) {
        final Optional<RouteDto> routeDto = getById(routeId);
        routeDto.ifPresent(route -> route.setStartTime(newBeginTime));
        return routeDto.map(routeMapper::dtoToEntity)
                .map(routeRepository::save)
                .map(routeMapper::entityToDto);
    }

    @Override
    public Optional<RouteDto> updateEndTime(long routeId, LocalTime newEndTime) {
        final Optional<RouteDto> routeDto = getById(routeId);
        routeDto.ifPresent(route -> route.setEndTime(newEndTime));
        return routeDto.map(routeMapper::dtoToEntity)
                .map(routeRepository::save)
                .map(routeMapper::entityToDto);
    }

    @Override
    public Optional<RouteDto> updateBeginStation(long routeId, long stationId) {
        final Optional<RouteDto> routeDto = getById(routeId);
        routeDto.ifPresent(route -> stationService.getStation(stationId).ifPresent(route::setStartStation));
        return routeDto.map(routeMapper::dtoToEntity)
                .map(routeRepository::save)
                .map(routeMapper::entityToDto);
    }

    @Override
    public Optional<RouteDto> updateEndStation(long routeId, long stationId) {
        final Optional<RouteDto> routeDto = getById(routeId);
        routeDto.ifPresent(route -> stationService.getStation(stationId).ifPresent(route::setEndStation));
        return routeDto.map(routeMapper::dtoToEntity)
                .map(routeRepository::save)
                .map(routeMapper::entityToDto);
    }

    @Override
    public void delete(long id) {
        routeRepository.deleteById(id);
    }
}
