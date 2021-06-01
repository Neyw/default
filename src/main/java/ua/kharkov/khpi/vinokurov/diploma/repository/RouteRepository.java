package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.RouteEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.StationEntity;

import java.util.List;


public interface RouteRepository extends PagingAndSortingRepository<RouteEntity, Long> {
    List<RouteEntity> findAllByStartStationAndEndStation(StationEntity startStation, StationEntity endStation);

    List<RouteEntity> findAllByStartStation(StationEntity startStation);

    List<RouteEntity> findAllByEndStation(StationEntity endStation);

    @Override
    List<RouteEntity> findAll();
}
